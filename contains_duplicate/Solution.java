package kai.leetcode.algorithm.contains_duplicate;

import java.util.HashSet;

public class Solution {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length < 1)
			return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (set.contains(i)) {
				return true;
			} else {
				set.add(i);
			}
		}
		return false;

	}
}
