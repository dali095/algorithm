package kai.leetcode.algorithm.search_for_a_range;

//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//Your algorithm's runtime complexity must be in the order of O(log n).
//
//If the target is not found in the array, return [-1, -1].
//
//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].

public class Solution {
	public int[] searchRange(int[] A, int target) {

		int low = 0;
		int high = A.length - 1;
		int[] result = new int[2];
		double t1 = target - 0.1;
		double t2 = target + 0.1;

		while (low < high) {
			int mid = (low + high) / 2;
			if (A[mid] > t1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		if (A[low] == target)
			result[0] = low;
		else if (low + 1 < A.length && A[low + 1] == target)
			result[0] = low + 1;
		else
			result[0] = -1;

		low = 0;
		high = A.length - 1;

		while (low < high) {
			int mid = (low + high) / 2;
			if (A[mid] > t2) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		if (A[low] == target)
			result[1] = low;
		else if (low - 1 >= 0 && A[low - 1] == target)
			result[1] = low - 1;
		else
			result[1] = -1;

		return result;

	}
}
