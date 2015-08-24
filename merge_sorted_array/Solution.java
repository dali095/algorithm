package kai.leetcode.algorithm.merge_sorted_array;

//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		if (A == null || B == null)
			return;
		else if (m == 0 && n == 0)
			return;
		else if (m == 0) {
			for (int i = 0; i < B.length; i++) {
				A[i] = B[i];
			}
			return;
		} else if (n == 0)
			return;

		for (int i = m + n - 1; i >= 0; i--) {
			if (n == 0)
				return;
			else if (m == 0) {
				for (int j = n - 1; j >= 0; j--) {
					A[i] = B[j];
					i--;
				}
				return;
			} else if (A[m - 1] > B[n - 1]) {
				A[i] = A[m - 1];
				m--;
			} else {
				A[i] = B[n - 1];
				n--;
			}
		}

	}
}