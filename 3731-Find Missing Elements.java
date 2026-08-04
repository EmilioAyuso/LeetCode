import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
    You are given an integer array nums consisting of unique integers.
    Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
    The smallest and largest integers of the original range are still present in nums.
    Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.You are given an integer array nums consisting of unique integers.
    */

    public List<Integer> findMissingElements(int[] nums) {
        //One way will be 1. Look min/max and detect witch integers are in nums 2. Create a list with the numbers that aint there
        
        //1. Look min/max and detect witch integers are in nums
        int min = nums[0];
        int max = nums[0];
        boolean isIn[] = new boolean[101];

        isIn[nums[0]] = true;
        for (int i=1; i<nums.length; i++)
        {
            if (nums[i]>max)
                max = nums[i];
            if (nums[i]<min)
                min = nums[i];

            isIn[nums[i]] = true;
        }

        //2. Create a list with the numbers that aint there
        List<Integer> res = new ArrayList<Integer>();
        for (int i= min; i <= max; i++)
            if(!isIn[i])
                res.add(i);

        return res;

        
        /*
        //simpliest way will be 1. Look min/max 2. Create a list from min to max 3.Eliminate the ones that are in nums: n*2 
        
        //1 Look for min/max
        int min = nums[0];
        int max = nums[0];

        for (int i=1; i<nums.length; i++)
        {
            if (nums[i]>max)
                max = nums[i];
            if (nums[i]<min)
                min = nums[i];
        }

        // 2. Create a list from min to max
        List<Integer> res = new ArrayList<Integer>();
        for (int i= min; i <= max; i++)
            res.add(i);

        // 3. Eliminate the ones that are in nums
        for (int i=0; i<nums.length; i++)
        {
            res.remove((Integer)nums[i]);

        }
        return res;
        */
    }
}