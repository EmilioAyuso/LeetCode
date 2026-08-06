import java.util.HashMap;
import java.util.Map;
/**
 * You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // We are going to store each value with its index, and in a loop search whether the other addend has already been seen 
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)
        {
            if(map.get(target-nums[i]) != null)
                return new int[]{map.get(target-nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
        /*
        for (int i=0; i<nums.length-1; i++)
        {
            for (int j=i+1; j<nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i,j};
        }
        return null;  
        */
    }
}