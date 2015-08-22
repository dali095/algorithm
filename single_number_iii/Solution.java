package kai.leetcode.algorithm.single_number_iii;

//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//For example:
//
//Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
//
//Note:
//The order of the result is not important. So in the above example, [5, 3] is also correct.
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
//

public class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 1)
            return null;
            
        if (nums.length == 2)
            return nums;
        int[] result = new int[2];
        int xy = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xy = xy ^ nums[i];
        }

        int t = 1;
        while ((t & xy) == 0)
            t = t << 1;
            
        int x1 = 0;
        for (int i : nums) {
            if ((i & t) == 0) {
                x1 = x1 ^ i;
            }
        }
        result[0] = x1;
        result[1] = xy ^ x1;

        return result;
    }
}