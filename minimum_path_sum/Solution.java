package kai.leetcode.algorithm.minimum_path_sum;

//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 1 && n == 1)
            return grid[0][0];
        
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                map[i][j] = -1;
            }
        }
        
        map[0][0] = grid[0][0];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (i == 0 && j == 0)
                    continue;
                int min = Integer.MAX_VALUE;
                if (i - 1 >= 0 && map[i - 1][j] >= 0)
                    min = map[i - 1][j];
                if (j - 1 >= 0 && map[i][j - 1] < min && map[i][j - 1] >= 0)
                    min = map[i][j - 1];
                map[i][j] = grid[i][j] + min;
            }
        }
        
        return map[m - 1][n - 1];
        
    }
}