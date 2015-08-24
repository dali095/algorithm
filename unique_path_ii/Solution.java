package kai.leetcode.algorithm.unique_path_ii;

//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.
//
//Note: m and n will be at most 100.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1)
            return 0;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;
            }
        }
        
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == -1)
                    continue;
                if (i - 1 >= 0 &&  obstacleGrid[i - 1][j] != -1)
                    obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i - 1][j];
                if (j - 1 >= 0 &&  obstacleGrid[i][j - 1] != -1)
                    obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i][j - 1];
            }
        }
        
        if (obstacleGrid[m - 1][n - 1] < 1)
            return 0;
        return obstacleGrid[m - 1][n - 1];
    }
}