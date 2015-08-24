package kai.leetcode.algorithm.kth_largest_element_in_an_array;

//Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//For example,
//Given [3,2,1,5,6,4] and k = 2, return 5.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ array's length.

import java.util.*;

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		if (nums.length < k)
			return -1;

		if (nums.length < 2)
			return nums[0];

		Map<Integer, Integer> topMap = new TreeMap<Integer, Integer>();
		for (int i : nums) {
			if (topMap.containsKey(i)) {
				topMap.put(i, topMap.get(i) + 1);
			} else {
				topMap.put(i, 1);
			}
		}

		k = nums.length - k + 1;
		for (int i : topMap.keySet()) {
			if (k <= topMap.get(i))
				return i;
			else
				k = k - topMap.get(i);

		}
		return 0;
	}
}
