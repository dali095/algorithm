package kai.leetcode.algorithm.major_elememt;

//Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
	public int majorityElement(int[] nums) {
		int head = 0;

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] != nums[head]) {
				int j = head + 1;
				while (j <= i && nums[j] != nums[head])
					j++;
				head = j;
				if (j > i)
					i = j;
			}
		}
		return nums[head];
	}
}