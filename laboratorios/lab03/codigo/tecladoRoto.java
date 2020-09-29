import java.util.*;
/**
 * Write a description of class TecladoRoto here.
 * 
 * @author Juan Andres Henao, Carlos Mosquera
   */
public class tecladoRoto{
    public static void solucion(String s){
        s = separarEspacios(s);
        Stack<String> lista = new Stack<String>();
        String[] n = s.split(" ");
        String textoIni = "";
        String textoFin = "";
        String textoLista = "";
        String texto = "";
        for(int i = 0; i < n.length; i++){
            if(n[i].equals("[") && i+1 < n.length){
                if(!n[i+1].equals("]") && !n[i+1].equals("[")){
                    textoIni =  n[i+1]+ textoIni;
                    i++;
                }           
            }else if(n[i].equals("]")){
                if(!n[i+1].equals("]") && !n[i+1].equals("[")){
                    textoFin = textoFin + n[i+1];
                    i++;
                }
            }else if(!n[i].equals("]") && !n[i].equals("[")){
                lista.push(n[i]);
            }
        }
        while(!lista.isEmpty()){
            textoLista = textoLista + lista.pop();
        }
        texto = textoIni + textoLista + textoFin;
        System.out.println(texto);
    }
    public static String separarEspacios(String s){
        String nuevaS = "";
        int cont = 0;
        for(int i = 0; i < s.length(); i++){
            String pal = s.substring(i,i+1);
            if((pal.equals("]")) || pal.equals("[")){                 
                if(cont == 0){
                    nuevaS = nuevaS + " " + pal + " ";  
                    cont = 1;
                }else{
                    nuevaS = nuevaS + pal + " "; 
                }
            }else{
                nuevaS = nuevaS + pal;
                cont = 0;      
            }       
        }
        return nuevaS.trim();
    }
}