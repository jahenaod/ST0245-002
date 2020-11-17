public class BuildTree
{
    public BuildTree(){}; 
    
    public Node decisionTree(String[][] m){
        return decisionTreeAux(m,0);
    }
    
    public Node decisionTreeAux(String[][] m, int cont){
        if(cont > 7) return null;
        Node f = new Node(m);
        if((f.trueMatrix.length) <= 150 || (f.falseMatrix.length <= 150)) return f;
        cont = cont++;
        f.trueBranch = decisionTreeAux(f.trueMatrix, cont);
        f.falseBranch = decisionTreeAux(f.falseMatrix, cont);
        return f;
    }
}