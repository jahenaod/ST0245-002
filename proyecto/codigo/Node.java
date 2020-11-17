import java.util.*;
import javafx.util.Pair;
public class Node {
   
    public String[][] matriz;
    public Pair< Float, Pair<String,Integer>>  mejorPregunta;
    public int mejorCol;
    public String mejorVal;
    public boolean exito; 
    public Node trueBranch;
    public Node falseBranch;
    public String[][] trueMatrix;
    public String[][] falseMatrix;

    public Node(String[][] M){
        matriz = M;
        mejorPregunta = Arbol.encontrarMejorPregunta(matriz); 
        mejorVal = mejorPregunta.getValue().getKey();
        mejorCol = mejorPregunta.getValue().getValue();
        Pair<String[][],String[][]> parejaDeMatrices = Arbol.dividirUnaMatrizEnDosMatrices(M, mejorCol, mejorVal);
        trueMatrix = parejaDeMatrices.getKey();
        falseMatrix = parejaDeMatrices.getValue();
        exito = Arbol.contarEtiquetasDeUnaMatriz(matriz);
    }       
}
