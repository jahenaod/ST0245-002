import java.io.*;
import java.util.*;
import javafx.util.Pair;
/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String[] args) throws Exception{
        BufferedReaderClass br = new BufferedReaderClass("prueba135000.csv");
        BuildTree t = new BuildTree();
        long start = System.currentTimeMillis();
        Node y = t.decisionTree(br.matriz);
        long finalT = System.currentTimeMillis();
        System.out.println("It's takes " + (finalT -start));
        
        BufferedReaderClass br2 = new BufferedReaderClass("test135000.csv");
        double[] in = Test.information(br2.matriz, y);
        System.out.println("Precision: " + in[0]);
        System.out.println("Sensibilidad: " + in[1]);
        System.out.println("Exactitud: " + in[2]);
    }
}
