
/**
 * Parser for ST0244 language
 *
 * @author Helmuth Trefftz
 *
 * El lenguaje que se reconoce es el siguiente:
 *
 * <program> ::= program <funDefinitionList> endprogram
 * <funDefinitionList> ::= <funDefinition> <funDefinitionList>
 *              | epsilon
 * <funDefinition> ::= def variable lparen <varDefList> rparen
 *              <varDefList>
 *              <statementList>
 *              enddef
 * <varDefList> ::= <varDef> <varDefList>
 *              | epsilon
 * <varDef> ::= int variable
 * <statementList> ::= <statement> <statementList>
 *              | epsilon
 * <statment> ::= read variable 
 *              | print variable 
 *              | call variable lparen <variableList> rparen
 * <variableList> ::= <variable> <variableList>
 *              | epsilon
 */
import java.io.FileNotFoundException;

public class Parser {

    Token token;
    Lexer lexer;

    /**
     * Constructor The name of the file with the source code is received as
     * parameter
     *
     * @param fileName Name of file where the source code is be read
     */
    public Parser(String fileName) {
        try {
            lexer = new Lexer(fileName);
            token = lexer.nextToken();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(1);
        }
    }

    /**
     * Check if the current token is the same as expected, as per the derivation
     *
     * @param expected Expected token
     */
    private void recognize(int expected) {
        if (token.code == expected) {
            token = lexer.nextToken();
        } else {
            System.out.print("Syntax Error. ");
            System.out.println("Expected: " + lexer.getTokenText(expected)
                + " found: " + lexer.getTokenText(token.code));
            System.exit(2);
        }
    }

    /**
     * Check if the current token is a variable Returns the name of the
     * variable. This will be needed when generating code.
     */
    private String recognizeVariable() {
        String text;
        if (token.code == Lexer.VARIABLE) {
            text = token.text;
            // Generate code for the variable
            token = lexer.nextToken();
        } else {
            text = null;
            System.out.print("Syntax Error. ");
            System.out.println("Expected: variable found: "
                + lexer.getTokenText(token.code));
            System.exit(2);
        }
        return text;
    }

    private int recognizeConstant() {
        int text;
        if (token.code == Lexer.CONSTANT) {
            text = token.num;
            // Generate code for the constant
            token = lexer.nextToken();
        } else {
            text = 0;
            System.out.print("Syntax Error. ");
            System.out.println("Expected: variable found: "
                + lexer.getTokenText(token.code));
            System.exit(2);
        }
        return text;
    }

    /**
     * <program> ::= program <funDefinition> endprogram
     */
    public void program() {
        recognize(Lexer.PROGRAM);
        funDefinitionList();
        recognize(Lexer.ENDPROGRAM);
        if (token.code == Lexer.EOF) {
            System.out.println("No errors found");
        }
    }

    /**
     * <funDefinitionList> ::= <funDefinition> <funDefinitionList>
     *                  | epsilon
     */
    public void funDefinitionList() {
        if(token.code == Lexer.DEF) {
            funDefinition();
            funDefinitionList();
        } else {
            // nothing, epsilon
        }
    }

    /**
     * <funDefinition> ::= def variable lparen <varDefList> rparen 
     *              <varDefinitionList>
     *              <satamentList> 
     *              enddef
     *
     */
    public void funDefinition() {
        // Header
        recognize(Lexer.DEF);
        recognizeVariable();
        recognize(Lexer.LPAREN);
        varDefList();
        recognize(Lexer.RPAREN);
        // Variable definitions
        varDefList();
        assignList();
        // Statements
        decideList();
        cycleList();
        statementList();
        recognize(Lexer.ENDDEF);
    }

    /**
     * <varDefList> ::= <varDef> <varDefList>
     *                  | epsilon
     *
     */
    public void varDefList() {
        if (token.code == Lexer.INT) {
            // all variable definitions start with "int"
            // Not that the token is not recoginzed here but in
            // varDef
            varDef();
            varDefList();
        }
    }

    /**
     * <varDef> ::= int variable
     */
    public void varDef() {
        recognize(Lexer.INT);
        // Use the name of the variable to generate code
        String text = recognizeVariable();

        if (token.code == Lexer.ASSIGN){
            recognize(Lexer.ASSIGN);
            expr();
        }
    }

    /**
     * <statementList> ::= <statement> <statementList> 
     *                  | epsilon
     *
     */
    public void statementList() {
        if (token.code == Lexer.READ
        || token.code == Lexer.PRINT
        || token.code == Lexer.CALL) {
            statement();
            statementList();
        } else {
            // nothinge, epsilon
        }
    }

    /**
     *
     * <statment> ::= read variable 
     *              | print variable 
     *              | call variable lparen
     */         
    public void statement() {
        String text = null;
        switch (token.code) {
            case Lexer.READ:
            recognize(Lexer.READ);
            text = recognizeVariable();
            break;
            case Lexer.PRINT:
            recognize(Lexer.PRINT);
            text = recognizeVariable();
            break;
            case Lexer.CALL:
            recognize(Lexer.CALL);
            text = recognizeVariable();
            recognize(Lexer.LPAREN);
            variableList();
            recognize(Lexer.RPAREN);
            break;
            default:
            break;
        }
    }

    /**
     * <variableList> ::= <expr> <variablelist>
     *              |epsilon
     */
    public void variableList() {
        if(token.code == Lexer.VARIABLE || token.code == Lexer.CONSTANT) {
            expr();
            variableList();
        } else {
            // epsilon
        }
    }

    /**
     * <expr> ::= <term> <exprRest>
     */
    public void expr(){
        term();
        exprRest();
    }

    /**
     * <exprRest> ::= + <term> <exprRest> 
     *              | epsilon
     */
    public void exprRest(){
        if (token.code == Lexer.PLUS){
            recognize(Lexer.PLUS);
            term();
            exprRest();
        } else {
            //epsilon
        }
    }

    /**
     * <term> ::= <factor> <termRest>
     */
    public void term(){
        factor();
        termRest();
    }

    /**
     * <termRest> ::= * <factor> <termRest> 
     *              | epsilon
     */
    public void termRest(){
        if (token.code == Lexer.TIMES){
            recognize(Lexer.TIMES);
            factor();
            termRest(); 
        } else {
            //epsilon
        }
    }

    /**
     * <factor> ::= ( <expr> ) 
     *              | variable 
     *              | constant
     */
    public void factor(){
        if (token.code == Lexer.LPAREN){
            recognize(Lexer.LPAREN);
            expr();
            recognize(Lexer.RPAREN);
        } else if (token.code == Lexer.VARIABLE) {
            String text = recognizeVariable();
        } else {
            int num = recognizeConstant();
        }
    }

    /**
     * <condi> ::= <expr> == <expr>
     *              | <expr> != <expr>
     */
    public void condicion(){
        expr();
        if (token.code == Lexer.EQUALS){
            recognize(Lexer.EQUALS);
            expr();
        } else if (token.code == Lexer.DIFF){
            recognize(Lexer.DIFF);
            expr();
        }
    }

    /**
     * <assignList> ::= <assign> <assignlist>
     *              | epsilon
     */
    public void assignList(){
        if (token.code == Lexer.VARIABLE){
            assign();
            assignList();
        } else {
            // epsilon
        }
    }

    /**
     * <assign> ::= variable = <exp>
     */
    public void assign(){
        String text = recognizeVariable();
        recognize(Lexer.ASSIGN);
        expr();
    }

    /**
     * <deciList> ::= <deci> <deciList>
     *              | epsilon
     */
    public void decideList(){
        if (token.code == Lexer.IF){
            decide();
            decideList();
        } else {
            //epsilon
        }
    }

    /**
     * <deci> ::= if lparen <condi> rparen
     *              then
     *              <varDefList>
     *              <statementList>
     *              <assignList>
     *              <deciList>
     *              <cycleList>
     *              endif
     *              | if lparen <condi> rparen
     *              then
     *              <varDefList>
     *              <statementList>
     *              <assignList>
     *              <cycleList>
     *              else 
     *              <varDefList>
     *              <statementList>
     *              <assignList>
     *              <deciList>
     *              <cycleList>
     *              endif
     */
    public void decide(){
        recognize(Lexer.IF);
        recognize(Lexer.LPAREN);
        condicion();
        recognize(Lexer.RPAREN);
        recognize(Lexer.THEN);
        varDefList();
        assignList();
        statementList();
        decideList();
        cycleList();
        if (token.code == Lexer.ELSE){
            recognize(Lexer.ELSE);
            varDefList();
            assignList();
            statementList();
            decideList();
            cycleList();
        }
        recognize(Lexer.ENDIF);
    }

    /**
     * <cycleList> ::= <cycle> <cycleList>
     *              | epsilon
     */
    public void cycleList(){
        if (token.code == Lexer.WHILE){
            cycle();
            cycleList();
        } else {
            //epsilon
        }
    }

    /**
     * <cycle> ::= while lparen <condi> rparen
     *              do
     *              <varDefList>
     *              <statementList>
     *              <assignList>
     *              <deciList>
     *              <cycleList>
     *              endwhile
     */
    public void cycle(){
        recognize(Lexer.WHILE);
        recognize(Lexer.LPAREN);
        condicion();
        recognize(Lexer.RPAREN);
        recognize(Lexer.START);
        varDefList();
        assignList();
        statementList();
        decideList();
        cycleList();
        recognize(Lexer.ENDWHILE);
    }

}
