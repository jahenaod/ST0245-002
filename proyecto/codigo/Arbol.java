
import java.util.*;
import javafx.util.Pair;

public class Arbol
{
    public static TreeSet<String> valoresSinRep(String[][] m, int variable){
        TreeSet<String> respuesta = new TreeSet();
        if(!isNumeric(m[0][variable])){
            for (int fila = 0; fila < m.length; fila++){
                if(!m[fila][variable].equals("")){
                    respuesta.add(m[fila][variable]);
                }
            }
        }else{
            double promedio = promedioNumerico(m, variable);
            respuesta.add(String.valueOf(promedio));

        }  
        return respuesta; 
    }

    public static boolean contarEtiquetasDeUnaMatriz(String[][] m){
        int contSi = 0;
        int cont = m.length;
        for(int i = 0; i < m.length; i++){
            if(m[i][m[0].length-1].equals("1")){
                contSi++;
            }            
        } 
        double probabilidad = (contSi*100) / cont;
        if(probabilidad >= 51)return true; 
        return false;
    }     

    public static Pair<String[][],String[][]> dividirUnaMatrizEnDosMatrices(String[][] m, int posVariable, String valor){
        int nodoVerdadIzq = 0;
        if(isNumeric(valor)){
            double val = Double.parseDouble(valor);
            for (int fila = 0; fila < m.length; fila++){
                if (Double.parseDouble(m[fila][posVariable]) >= val){ // por ejemplo, valor es 3, 10 SMLVM, Masculino
                    nodoVerdadIzq++;
                }
            }
        }else{
            for (int fila = 0; fila < m.length; fila++){
                if (m[fila][posVariable].equals(valor)){ // por ejemplo, valor es 3, 10 SMLVM, Masculino
                    nodoVerdadIzq++;
                }
            }
        }
        int nodeFalsoDer = m.length - nodoVerdadIzq;
        String[][] nodoIzqVerdad = new String[nodoVerdadIzq][m[0].length];
        String[][] nodoDerechoFalso = new String[nodeFalsoDer][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length){ //
            if(!isNumeric(valor)){
                if(m[fila][posVariable].equals(valor)){
                    nodoIzqVerdad[filaN1]=m[fila];
                    fila++;filaN1++;
                }else{
                    nodoDerechoFalso[filaN2]=m[fila];
                    fila++;filaN2++;
                }
            }else{
                if(Double.parseDouble(m[fila][posVariable]) >= Double.parseDouble(valor)){
                    nodoIzqVerdad[filaN1]=m[fila];
                    fila++;filaN1++;
                }else{
                    nodoDerechoFalso[filaN2]=m[fila];
                    fila++;filaN2++;
                }
            }
        }
        // ...
        Pair<String[][],String[][]> parejaDeMatrices = new Pair(nodoIzqVerdad,nodoDerechoFalso);
        return parejaDeMatrices;
    }
    // IG = 1 - (p0)^2 - (p1)^2. P0 = no/total P1 = si
    public static float giniNodo(String[][] m){
        float losQueTienenExito = 0;
        for (int fila = 0; fila < m.length; fila++){
            if (m[fila][m[0].length-1].equals("1")){
                losQueTienenExito++;
            }
        }
        float losQueNoTienenExito = (float)m.length - losQueTienenExito;
        float proporcionDeLosQueTienenExito = losQueTienenExito/(float)m.length;
        float proporcionDeLosQueNoTieneExito = losQueNoTienenExito/(float)m.length;
        float impureza = 1 -    proporcionDeLosQueTienenExito*proporcionDeLosQueTienenExito - proporcionDeLosQueNoTieneExito*proporcionDeLosQueNoTieneExito;
        return impureza;        
    }

    public static double infoGain(String[][] nodoIzquierdo, String[][] nodoDerecho, float impurezaMatriz){
        double p = (double)nodoIzquierdo.length/((double)nodoIzquierdo.length + (double)nodoDerecho.length);
        return impurezaMatriz - p * giniNodo(nodoIzquierdo) - (1-p) * giniNodo(nodoDerecho);
    }

    public static Pair< Float, Pair<String,Integer>> encontrarMejorPregunta(String[][] matriz){ // n*m*n = O(n^2*m*2^m)
        double best_gain = 0; 
        String best_question = "";
        float curren_uncertainty = giniNodo(matriz);
        int columna = 0; 
        double promedio = 0;
        for(int i = 0; i < matriz[0].length-1; i++){ //t(n) = m;//columnas
            TreeSet<String> t = valoresSinRep(matriz, i);
            while(!t.isEmpty()){ // filas 
                String pregunta = t.pollFirst();                 
                Pair<String[][],String[][]> pareja = dividirUnaMatrizEnDosMatrices(matriz, i, pregunta); //filas
                if(pareja.getKey().length == 0 || pareja.getValue().length == 0){
                    continue;
                }else{
                    double gain = infoGain(pareja.getKey(), pareja.getValue(), curren_uncertainty);
                    if(gain >= best_gain){
                        best_gain = gain;
                        best_question = pregunta;
                        columna = i;
                    }
                }
            } 
        }
        Pair<String,Integer> m = new Pair(best_question, columna);
        Pair<Float,Pair<String,Integer>> mejorPregunta = new Pair(best_gain, m);        
        return mejorPregunta;
    }     

    public static double promedioNumerico(String[][] m, int columna) {
        double prom = 0;
        double suma = 0;
        double total = 0;
        for (int fila = 1; fila < m.length; fila++) {
            suma += Double.parseDouble(m[fila][columna]);
            total++;
        }
        prom = suma / total;
        return prom;
    }

    public static boolean isNumeric(String str)  
    {  
        try  
        {  
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    } 
}