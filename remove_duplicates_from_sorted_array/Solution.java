package kai.leetcode.algorithm.remove_duplicates_from_sorted_array;

//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example,
//Given input array nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

public class Solution {
	public int removeDuplicates(int[] A) {
		int i1 = 0;
		int i2 = 1;

		if (A.length <= 1)
			return A.length;

		for (i1 = 0; i1 < A.length; i1++) {
			while (i2 < A.length && A[i2] == A[i1])
				i2++;

			if (i2 == A.length) {
				return i1 + 1;
			}
			A[i1 + 1] = A[i2];
		}
		return i1 + 1;
	}
}
