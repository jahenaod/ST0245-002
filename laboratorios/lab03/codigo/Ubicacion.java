
import java.util.*;
import java.io.*;

/**
 * Write a description of class MapaCiudad here.
 * 
 * @author (Juan Andres Henao, Carlos Andres Mosquera)
 * @version (a version number or a date)
 */
public class Ubicacion
{
    private double id;
    private double x;
    private double y;
    private String nombre;
    public Ubicacion(double id, double x, double y, String nombre){
        this.id = id;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }
    public class MapaCiudad
    {
        private static ArrayList<Ubicacion> mapa = new ArrayList<>();
        public static void readData(String nameFile) throws FileNotFoundException{
            String namefile;
            if(nameFile.endsWith(".txt")){
                namefile=nameFile;
            } else{
                namefile= nameFile + ".txt";
            }
            Scanner read = new Scanner( new File(namefile));
            double cont = 0;
            while(read.hasNextLine()){
                String line = read.nextLine();
                Scanner scan = new Scanner(line);
                String a = scan.next(); 
                double id = Double.parseDouble(a);
                a = scan.next();
                double x = Double.parseDouble(a);
                a = scan.next();
                double y = Double.parseDouble(a);
                if(scan.hasNext()){
                    a = scan.next();
                    while(scan.hasNext()){
                        a = a +" "+ scan.next();
                    }
                }else{
                    a = null;
                }
                Ubicacion cord = new Ubicacion(id, x, y, a);
                mapa.add(cord);
                cont++;

            }
            read.close();
            System.out.println("Se han leído" + cont + " ubicaciones");
        }
    }
}