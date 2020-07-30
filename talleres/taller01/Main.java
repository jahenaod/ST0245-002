
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {

        Punto p = new Punto(-1, 1); //sople galactico

        System.out.printf("Punto: {%f, %f}\n", p.x(), p.y());

        System.out.println("Radio Polar: " + p.radioPolar());

        System.out.println("Angulo Polar: " + Math.toDegrees(p.anguloPolar()));

        System.out.println("Angulo Polar: " + p.distanciaEuclidiana(new Punto(1, 1)));

        System.out.println();

        Fecha fecha1 = new Fecha(12, 10, 2007);
        Fecha fecha2 = new Fecha(27, 9, 2018);

        System.out.println(fecha1);
        System.out.println(fecha2);
        
        System.out.println(fecha1.comparar(fecha2));

    }
}
