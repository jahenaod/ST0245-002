
/**
 * Write a description of class countXJava here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class countXJava
{
    public int countX(String str) {
        if(str.equals(""))
            return 0;

        if(str.charAt(0) == 'x')
            return 1 + countX(str.substring(1));

        else
            return countX(str.substring(1));

    }

}
