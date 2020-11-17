public class Test
{

    public static int[] etiquetasArbol(String[][] m, Node n){

        int etiquetaArbol [] = new int[m.length];

        for(int fila = 0; fila < m.length; fila++){
            if(determinarEtiqueta(m, fila, n)){
                etiquetaArbol[fila] = 1;
            }else{
                etiquetaArbol[fila] = 0;
            }
        }
        return etiquetaArbol;
    }  

    public static boolean determinarEtiqueta(String[][] m, int fila, Node n){
        int columna =  n.mejorCol;
        String valor = n.mejorVal;
        if(n.trueBranch == null || n.falseBranch == null) return n.exito;

        if(Arbol.isNumeric(valor)){
            double v = Double.parseDouble(valor);
            if(Double.parseDouble(m[fila][columna]) >= v){
                return determinarEtiqueta(m, fila, n.trueBranch);
            }else{
                return determinarEtiqueta(m, fila, n.falseBranch);
            }
        }else{
            if(m[fila][columna].equals(valor)){
                return determinarEtiqueta(m, fila, n.trueBranch);
            }else{
                return determinarEtiqueta(m, fila, n.falseBranch);
            }
        }
    }

    public static double[] information(String[][] m, Node n){
        int[] etiquetas = etiquetasArbol(m,n);
        double truePositives = 0; 
        double falseNegatives = 0;
        double falsePositives = 0;
        double trueNegatives = 0;
        for(int fila = 0; fila < m.length; fila++){
            if(Integer.parseInt(m[fila][m[0].length-1]) == (etiquetas[fila]) && (etiquetas[fila] == 1)){
                truePositives++;
            }else if(Integer.parseInt(m[fila][m[0].length-1]) != (etiquetas[fila]) && (etiquetas[fila] == 1)){
                falsePositives++; 
            }else if(Integer.parseInt(m[fila][m[0].length-1]) == (etiquetas[fila]) && (etiquetas[fila] == 0)){
                trueNegatives++;
            }else if(Integer.parseInt(m[fila][m[0].length-1]) != (etiquetas[fila]) && (etiquetas[fila] == 0)){
                falseNegatives++;
            }            
        }
        double precision = (truePositives) / (truePositives + falsePositives);
        double sensibilidad = (truePositives) / (truePositives + falseNegatives);
        double exactitud = (truePositives + trueNegatives) / (falsePositives + truePositives + falseNegatives+trueNegatives);
        double[] info = new double[3];
        info[0] = precision;
        info[1] = sensibilidad;
        info[2] = exactitud;
        return info;
    }
}

