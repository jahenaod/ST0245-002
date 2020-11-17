
import java.io.*;
import java.util.*;

public class BufferedReaderClass
{
    public  String matriz[][];
    public static List<Integer> miLista = new ArrayList<Integer>(List.of(0, 1, 2, 3, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,27, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 43, 44, 46, 47, 48, 49, 50, 51, 55,56, 57, 58, 61, 62, 63, 64, 75, 76));
    public BufferedReaderClass(String s) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(s));
        String line = br.readLine();
        int count = 0;
        while((line = br.readLine())!= null){
            count++;
        }
        System.out.println(count);
        br.close();
        /////////////////////////////////////////////////////////////
        matriz = new String[count][30];
        BufferedReader br2 = new BufferedReader(new FileReader(s));
        line = br2.readLine();
        int z= 0;
        int v =0;
        while((line = br2.readLine()) != null){
            String[] splitted = line.split(";");
            for(int i =0; i< splitted.length; i++) {
                if(miLista.contains(i)){
                    continue;                
                }else{
                    matriz[z][v]= splitted[i];
                    v++;
                } 
            }
            v=0;
            z++;
        }
    }
}