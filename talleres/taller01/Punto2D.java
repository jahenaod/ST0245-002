
/**
 * Write a description of class Punto2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto2D
{
    
    private int x;
    private int y;

 

    /**
     * Se inicializan los atributos de clase
     */
    public Punto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

 

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public int x() {
        return this.x;
    }

 

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public int y() {
        return this.y;
    }
   

}
