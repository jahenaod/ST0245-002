/**
 *
 * @author Carlos Andres Mosquera, Juan Andres Henao 
 * 
 */

public class Fecha {

    private final int dia;
    private final int mes;
    private final int anyo;

    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Fecha(int dia, int mes, int anyo) {

        this.dia = dia;
        this. mes = mes;
        this.anyo = anyo;

    }

    /**
     * Método para obtener la variable global dia.
     *
     * @return el dia
     */
    public int dia() {
        return dia;

    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes
     */
    public int mes() {

        return mes;

    }

    /**
     * Método para obtener la variable global anio.
     *
     * @return el año
     */
    public int anyo() {

        return anyo;

    }

    /**
     * @param otra representa la fecha con la cual se va a comparar.
     *
     * El método comprar se encarga de devolvernos respuesta a tres posibilidades.
     * 1: si la fecha es menor que la otra retorna -1.
     * 2: si la fecha es igual que la otra retorna 0.
     * 3: si la fecha es mayor que la otra retorna 1.
     *
     * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
     *
     */

    public int comparar(Fecha otro) {

        if (this.anyo < otro.anyo)             
            return -1;     
        if (this.anyo > otro.anyo)            
            return 1;        
        if (this.mes < otro.mes)             
            return -1;        
        if (this.mes > otro.mes)             
            return 1;        
        if (this.dia < otro.dia)             
            return -1;        
        if (this.dia > otro.dia)             
            return 1;

        return 0;

    }

    /**
     * toString se encargará de convertir el tipo abstracto fecha en un tipo cadena
     * para su posterior visualización
     *
     * @return una cadena que contiene la fecha
     */
    public String toString() {
        String texto = this.dia + "/" + this.mes + "/" + this.anyo;
        return texto;

    }
}
