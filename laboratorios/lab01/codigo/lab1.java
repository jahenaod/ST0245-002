
/**
 * Esta clase 
 * 
 * @author Juan Andres Henao, Carlos Andres Mosquera 
 * @version 1
 */
public class lab1
{
    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length());
    }

    private static int lcsDNAAux(String string1, String string2, int m, int n) {
        if(m<1||n<1){
            return 0;
        }
        if(string1.charAt(m-1)==string2.charAt(n-1)){
            return 1 + lcsDNAAux(string1.substring(0, m-1),
                string2.substring(0, n-1), m-1, n-1);
        }
        return Math.max(lcsDNAAux(string1.substring(0, m-1),
                string2, m-1, n-1), lcsDNAAux(string1, string2.substring(0, n-1), m-1, n-1));
    }
    
    public static int ways(int n){
        if(n<=2) return n;
        return ways(n-1) + ways(n-2);
    }

}
