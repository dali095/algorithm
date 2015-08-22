package kai.leetcode.algorithm.unique_path;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i > 0)
                    map[i][j] = map[i][j] + map[i - 1][j];
                if (j > 0)
                    map[i][j] = map[i][j] + map[i][j - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
