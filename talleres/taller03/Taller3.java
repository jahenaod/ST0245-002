/**
 *
 * La clase Taller3 tiene como objtivo dar solución a los puntos del taller 3
 *
 * @author Juan Andres Henao, Carlos Andres Mosquera
 * @version 1
 */

public class Taller3 {
    /**
     *
     * El método torresDeHannoi es un auxiliar del proceso 
     * @param n numero de discos
     * 
     */	
    public static void hanoi(int  topN){
        hanoi(topN, "Tower1", "Tower2", "Tower3");
    }

    public static void hanoi(int topN, String a, String b, String c){
        if (topN == 1)
        
            System.out.println (a + " -> " + c);
        else {
            hanoi(topN - 1 ,a , c ,b);
            hanoi(1 , a , b , c);
            hanoi(topN - 1 ,b , a ,c);
        }
    }

    /**
     *
     * El método permutationAux es el core del proceso, en el se busca conseguir
     * las posibles permutaciones que puede tener la cadena str 
     * @param str es la cadena a permutar
     * @param prefix cadena auxiliar donde se guarda la cadena de salida
     *
     * Las cadenas de salida tienes una longitud de lenght de la cadena s
     * Ej: para la cadena AB se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
     * donde los caracteres no se repiten pero el orden tiene un papel importante.
     *
     */
    public static void permutation(String s, String str) {

        permutation("", str);

    }

    private static void permutationAux(String prefix, String str) {
        int n = str.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), 
                str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}
