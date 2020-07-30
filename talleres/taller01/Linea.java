
/**
 * Write a description of class Linea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Linea
{
    private Punto2D puntoi;
    private Punto2D puntof;
    private Punto2D[] arreglo;

    public Linea(Punto2D p1, Punto2D p2) {
        this.puntoi = p1;
        this.puntof = p2;
        this.arreglo= new Punto2D[p2.x()];
    }

    public Punto2D[] intermedios(){
        int x= puntoi.x();
        int y=puntoi.y();
        int x2 = puntof.x();
        int y2 = puntof.y();
        int pendiente = y2 - y/x2 - x;
        for(int i=0; i < arreglo.length; i++){
            x+=1;
            y+=pendiente;
            arreglo[0]=new Punto2D(x,y);
        }

        return arreglo;
    }

   
}
