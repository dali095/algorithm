package kai.leetcode.algorithm.maximum_subarray;

//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.


public class Solution {
    public int maxSubArray(int[] A) {
                int result = A[0];
        int currentMax = A[0];
        
        // assert A.length != 0
        
        if (A == null || A.length == 0)
        {
            return 0;
        }
        
        for (int i = 1; i < A.length; i++)
        {
            if (A[i] > A[i] + currentMax)
            {
                currentMax = A[i];
            }
            else
            {
                currentMax = A[i] + currentMax;
            }
            
            if (currentMax > result)
            {
                result = currentMax;
            }
            
            
            // currentMax = max(A[i], A[i] + currentMax);
            // result = max(currentMax, result);
        }
            return result;
    }
}