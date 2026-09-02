/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
 */
class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        int j;
        for(int i=grid.length-1; i>=0; i--)
        {
            j=grid[0].length-1;
            if(grid[i][j] >= 0)
                break;
            for(; j>=0; j--)
            {
                if(grid[i][j] >= 0)
                    break;
                res++;
            }
        }
        return res;
    }
}