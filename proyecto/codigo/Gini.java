
/**
 * Write a description of class Gini here.
 * 
 * @author Juan Andres Henao Diaz / Carlos Andres Mosquera 
 * @version 1
 */
public class Gini
{
        public static float sacarElGiniDeUnaMatriz(String[][] m){ 
        int ceros = enCuantasFilasLaVariableEsIgualALaCondicion(m, m[0].length-1, "0");
        int unos = m.length - ceros;
        float gini = 1 - ((ceros/m.length * ceros/m.length) + (unos/m.length*unos/m.length));
        return gini;
    }

    private static int enCuantasFilasLaVariableEsIgualALaCondicion(String[][] m, int variable, String valor){
        int enCuantasFilasLaVariableEsIgualALaCondicion = 0;
        for (int filas = 0; filas < m.length; filas++)
            if (m[filas][variable].equals(valor))
                enCuantasFilasLaVariableEsIgualALaCondicion++;
        return enCuantasFilasLaVariableEsIgualALaCondicion;
    }
}


