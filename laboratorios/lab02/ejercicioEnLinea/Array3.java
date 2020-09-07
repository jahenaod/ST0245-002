
/**
 * Write a description of class Array3 here.
 * 
 * @author Carlos Andres Mosquera, Juan Andres Henao 
 * @version (a version number or a date)
 */
public class Array3
{
    public boolean canBalance(int[] nums) {
        int lSum = 0;

        for (int i = 0; i < nums.length; i++) {
            lSum += nums[i];
            int rSum = 0;
            for (int j = nums.length-1; j > i; j--) {
                rSum += nums[j];
            }
            if (rSum == lSum)
                return true;
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int numFound = 0;
        if(inner.length == 0) {
            return true;
        }

        int k = 0;
        for(int i = 0; i < outer.length; i++) {
            if(outer[i] == inner[k]) {
                numFound++;
                k++;
            } else if(outer[i] > inner[k]) {
                return false;
            }

            if(numFound == inner.length)
                return true;
        }

        return false;
    }

    public int maxSpan(int[] nums) {
        int span = 0;
        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    tmp = j-i+1;
                    span = Math.max(tmp,span);
                }
            }
        }
        return span;
    }

    public int[] seriesUp(int n) {
        int[] result = new int[n * (n + 1) / 2];
        int i = 0;
        for (int j = 1; j <= n; ++j)
            for (int k = 1; k <= j; ++k)
                result[i++] = k;
        return result;
    }

    public int[] squareUp(int n) {
        int[] result = new int[n * n];
        int x = n-1, pass = 1, index = 0;
        if(n == 0) { return result; }
        for(int i = n-1; i < result.length; i+=n) {
            index = i;
            for(int k = 1; k <= pass; k++) {
                if(k == 0) { break; }
                result[index] = k;
                index--;
            }
            pass++;
        }
        return result;
    }
    }

   



    

