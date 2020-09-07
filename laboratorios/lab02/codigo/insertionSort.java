
/**
 * Write a description of class mergeSort here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class insertionSort
{
        public static int[] insertionSort (int[] nums){ 
        int temp=0; //T2(n)=c_1 
        for(int i = 1; i < nums.length;i++){//T3(n)=c_2+c_3*n 
            for(int j=i-1;j>=0 && nums[j+1] < nums[j];j--){//T4(n)=(c_4+c5(n-1))*n 
                temp=nums[j+1];  
                nums[j+1]=nums[j];   
                nums[j]=temp;     //T5(n)=c_6(n-1)*n 
            } 
        } 
        return nums;//T6(n)=c_7 
    } 

    public static void main(String args[]) throws Exception{
        long ti=0;
        long tf=0;
        for(int n = 1000000; n <= 20000000; n =+ 1000000){
            int[] arreglo = new int [n];
            for(int i = 0; i < n; i++){
                arreglo[i] = n-i;
            }
            ti = System.currentTimeMillis();
            insertionSort(arreglo);
            tf = System.currentTimeMillis();
            System.out.println(tf-ti);
        }
        System.out.println(tf-ti);
    }

}    

