
/**
 * Write a description of class countHi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class countHiJava
{

    public int countHi(String str) {

        if (str.length() < 2)
            return 0;

        if (str.substring(0,2).equals("hi"))
            return 1 + countHi(str.substring(1));

        else
            return countHi(str.substring(1));

    }

}
