
/**
 * La clase Punto tiene la intención de representar coordenadas en el espacio y calcular su distancia.
 * 
* @author Juan Andres Henao, Carlos Andres Mosquera
* @version 1
 */
import java.lang.Math;
public class Punto {

 

    private double x;
    private double y;

 

    /**
     * Se inicializan los atributos de clase
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

 

    /**
     * Método para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double x() {
        return this.x;
    }

 

    /**
     * Método para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double y() {
        return this.y;
    }

 

    /**
     * Método para obtener el radio polar,
     * en este caso se puede obtener por medio del teorema de pitágoras.
     * 
     *
     * @return radio polar
     *
     * 
     */
    
    public double radioPolar() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    /**
     * Método para obtener el ángulo polar,
     * en este caso se puede obtener por medio de la tangente inversa.
     * 
     *
     * @return angulo polar
     *
     * 
     */
    public double anguloPolar() {
        return Math.atan2(this.y, this.x);
    }

 

    /**
     * Método para obtener la distacia euclidiana. La distacia
     * euclidiana o euclídea es la distancia "ordinaria" (que se mediría con una regla) entre 
     * dos puntos de un espacio euclídeo, la cual se deduce a partir del teorema de Pitágoras.
     * En otras palabras es halla el radio polar a la diferencia entre los dos puntos.
     *
     *
     *
     * @return distancia euclidiana
     * (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este parámetro hace referencia a otro
     * Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado.
     * 
     */
  
    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow( (this.x - otro.x), 2) +
                         Math.pow( (this.y - otro.y), 2) );
    }
}