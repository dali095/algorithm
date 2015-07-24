package kai.leetcode.algorithm.product_of_array_except_self;

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length < 2)
			return nums;

		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = 1;
		}

		int t = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = nums[i - 1] * t;
			t = t * nums[i - 1];
		}

		t = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i] * t;
			t = t * nums[i];
		}

		return result;

	}
}
