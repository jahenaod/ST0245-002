
/**
 * Write a description of class recursion2 here.
 * 
 * @author (Juan Andres Henao, Carlos Andres Mosquera) 
 * @version (a version number or a date)
 */
public class recursion2
{
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length)				
            return target == 0; 
        if (groupSum6(start + 1, nums, target - nums[start]))		
            return true;
        if (nums[start] == 6)							
            target -= 6;
        return groupSum6(start + 1, nums, target); 			
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start >= nums.length) 
            return target == 0; 							 
        else 
            return (groupNoAdj(start + 2, nums, target - nums[start]) || 	
                groupNoAdj(start + 1, nums, target)); 				
    }

    public boolean splitOdd10(int[] nums)
    {	return sidesAreOdd10(nums, 0, 0, 0);	}

    public boolean sidesAreOdd10(int[] nums, int i, int group1, int group2)
    {
        if(i == nums.length)
            return (group1 % 2 == 1 && group2 % 10 == 0 
                || group2 % 2 == 1 && group1 % 10 == 0);
        if(sidesAreOdd10(nums, i + 1, group1 + nums[i], group2))
            return true;

        return sidesAreOdd10(nums, i + 1, group1, group2 + nums[i]);
    }

    public boolean splitArray(int[] nums)
    {	return sidesAreEqual(nums, 0, 0);	}

    public boolean sidesAreEqual(int[] nums, int i, int balance)
    {
        if(i == nums.length)
            return (balance == 0);
        if(sidesAreEqual(nums, i + 1, balance + nums[i]))
            return true;
        return sidesAreEqual(nums, i + 1, balance - nums[i]);
    }

    public boolean groupSumClump(int start, int[] nums, int target)
    {
        if(start >= nums.length)
        {
            if(target == 0)
                return true;
            return false;
        }
        int i = start + 1;
        for(;  i < nums.length && nums[start] == nums[i]; i++);
        if(groupSumClump(i, nums, target - ((i - start) * nums[start])))
            return true;
        return groupSumClump(i, nums, target);	
    }

}
