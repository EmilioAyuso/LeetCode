import java.util.HashMap;
import java.util.Map;
/**
 * You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.
 * Return true if you can make arr equal to target or false otherwise.
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> numbTarget = new HashMap<>();
        for (int i=0;i<target.length; i++)
        {
            if(numbTarget.get(target[i]) == null)
                numbTarget.put(target[i], 1);
            else
                numbTarget.put(target[i], numbTarget.get(target[i])+1);
        }
        for (int i=0; i<arr.length; i++)
        {
            if(numbTarget.get(arr[i]) == null || numbTarget.get(arr[i]) == 0)
                return false;
            else
                numbTarget.put(arr[i],numbTarget.get(arr[i])-1);
        }
        return true;
    }
}