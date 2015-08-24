package kai.leetcode.algorithm.remove_duplicates_from_sorted_array_ii;

import java.util.ArrayList;

//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array nums = [1,1,1,2,2,3],
//
//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

public class Solution {
	public int removeDuplicates(int[] A) {
		if (A.length < 3)
			return A.length;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < A.length - 2; i++) {
			if (A[i] == A[i + 2]) {
				continue;
			} else {
				arr.add(A[i]);
			}
		}

		arr.add(A[A.length - 2]);
		arr.add(A[A.length - 1]);
		for (int i = 0; i < arr.size(); i++) {
			A[i] = arr.get(i);
		}
		return arr.size();
	}
}