/**
 * You are given an integer array nums of size n where n is even, and an integer k.
 * You can perform some changes on the array, where in one change you can replace any element in the array with any integer in the range from 0 to k.
 * You need to perform some changes (possibly none) such that the final array satisfies the following condition:
 * There exists an integer X such that abs(a[i] - a[n - i - 1]) = X for all (0 <= i < n).
 * Return the minimum number of changes required to satisfy the above condition.
 */
class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int res = n;
        int max1=0, max2=0, valueDiffer1=-1, valueDiffer2=-1;
        int maximumArr[] = new int[k+1]; 
        
        //1. Store the difference of each pair
        for (int i=0; i<n/2; i++)
            maximumArr[Math.abs(nums[i] - nums[n-1-i])]= maximumArr[Math.abs(nums[i] - nums[n-1-i])] + 1;
        
        //2. Identify which 2 difference are the most repeated
        for(int i=0; i<=k; i++)
        {
            if (maximumArr[i]>max1) // bigger than maximum
            {
                max2 = max1;
                valueDiffer2 = valueDiffer1;

                max1 = maximumArr[i];
                valueDiffer1 = i;
            }
            else if(maximumArr[i]>max2) // bigger than second maximum
            {
                max2 = maximumArr[i];
                valueDiffer2 = i;
            }
        }
        // 3. Verify which X has less changes
        if (valueDiffer1 != -1)
            res = Math.min(changesUsing(nums, valueDiffer1, k),res);
        if (valueDiffer2 != -1)
            res = Math.min(changesUsing(nums, valueDiffer2, k),res);
        return res;
    }
    //count number of changes if we want to persue X as the difference between each pair
    private int changesUsing(int[] nums, int x, int k)
    {
        int n = nums.length;
        int changes = 0;
        for (int i=0; i<n/2; i++)
        {
            if(Math.abs(nums[i] - nums[n-1-i]) != x)
            {
                if(Math.abs(nums[i] - k) >= x || Math.abs(nums[i]) >= x || Math.abs(nums[n-1-i] - k) >= x || Math.abs(nums[n-1-i]) >= x)
                    changes++;
                else
                    changes = changes+2;   
            }
        }
        return changes;
    }
}