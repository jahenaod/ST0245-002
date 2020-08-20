
/**
 * Write a description of class Taller4 here.
 * 
 * @author Juan Andres Henao Diaz, Carlos Andres Mosquera
 * @version (a version number or a date)
 */
public class Taller4
{

    public static int maxF(int index, int[] nums){
        if(nums.length==0){
            return Integer.MIN_VALUE;
        }else if(index==nums.length){
            return nums[index-1];
        }else{
            return Math.max(nums[index], maxF(index+1,nums));
        }
    }

    public static void main(String args[]){
        for(int n = 20; n<=40; n++){
            long ti = System.currentTimeMillis();
            maxF(0, new int[n]);
            long tf = System.currentTimeMillis();
            System.out.println(tf-ti);
        }
    }

    /**
     * Punto 2 Del taller
     */
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start == nums.length) // c1
            return target == 0;
        else
            return groupSum(start+1, nums, target) 
            || groupSum(start+1,nums,target-nums[start]);
    }

    /**
     * Punto opcional del taller 
     * Fibonacci
     */
    public int fibonacci(int n) {
        if(n<=1){
            return n;
        }else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}

