package kai.leetcode.algorithm.climbing_stairs;
//
//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
        
        if (n < 3)
            return n;
        
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++){
            result[i] = result[i - 1] + result[i - 2];
        }
        
        return result[n];
        
    }
}