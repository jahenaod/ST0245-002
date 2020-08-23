
/**
 * Write a description of class count7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class count7Java
{
    public int count7(int n) {
        int  cont = 0;
        if(n == 0) 
            return 0;

        if(n % 10 == 7)
            return 1 + count7(n / 10);

        return count7(n/10);
    }

}
