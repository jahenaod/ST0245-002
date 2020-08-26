
/**
 * Write a description of class Taller5 here.
 * 
 * @author Juan Andres Henao, Carlos Andres Mosquera
 * @version 1
 */
public class Taller5
{
    /**
     * Ejercicio 2 del taller5 que es un ciclo que sume cada uno de
     * los elementos del arreglo
     *
     */
    public static int suma (int[]array){
        int total = 0;                              //c1
        for(int i = 0; i < array.length; i++){      //c2 +  c3 
            total =+ array[i];                      //c4n
        }
        return total;                               //c5

        // T(n) = c1 + c2 + c5 + (c3 + c4)n
        // T(n) es O(n)
    }

    /**
     * ejercicio 1 del taller5, que requiere usar el 
     * metodo de ordenamiendo insersion sort
     */
    public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    } 

    public static void main(String[] args){

        for (int n = 10; n < 200; n = n + 10){ 

            long ti = System.currentTimeMillis();

            suma(new int[n]);

            long tf = System.currentTimeMillis();

            System.out.println(tf-ti);      

        }

    }


}

