
/**
 * Write a description of class array2 here.
 * 
 * @author Juan Andres Henao, Carlos Andres Mosquera 
 * 
 */
public class Array2
{
    public int countEvens(int[] nums) {
        int count = 0;           // C1
        for (int n : nums)      // n
            if (n % 2 == 0)      // n
                count++;          // n
        return count;            //C2
        //complejidad O(n)
    }

    public boolean only14(int[] nums) {
        for(int i=0;i<nums.length;i++)       //n
            if (nums[i] != 1 && nums[i]!= 4)    //n
                return false;                              //n
        return true;                                  //c
        //Complejidad O (n)
    }

    public int bigDiff(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        return max-min;

    }

    public int centeredAverage(int[] nums) {
        int min = nums[0];  //C1
        int max = nums[0];  //C2
        int sum = 0;

        for (int i = 0; i < nums.length; i++){ //C3
            sum += nums[i];                     //C4*n
            min = Math.min(min,nums[i]);        //C5*n
            max = Math.max(max,nums[i]);        //C6*n
        }
        sum = sum - max - min;                  //C8
        sum = sum / (nums.length-2);            
        return sum;                             

    }
    //Complejidad de O(n^2)

    public boolean lucky13(int[] nums) {
        boolean result = true;              //C1
        for (int i =0;i<nums.length ;i++)       //C2
            if ( nums[i] == 1 || nums[i] == 3)      //C3*n
                result = false;
        return result;                              //C4
    }
    //Complejidad de O(n)

 
 
}
