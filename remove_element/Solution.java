package kai.leetcode.algorithm.remove_element;

//Given an array and a value, remove all instances of that value in place and return the new length.
//
//The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0)
			return 0;

		int tail = A.length - 1;
		int head = 0;
		int count = A.length;

		while (head <= tail) {
			while (tail >= 0 && A[tail] == elem) {
				tail--;
				count--;
			}
			if (head <= tail) {
				while (head < A.length && A[head] != elem) {
					head++;
				}
				if (head <= tail) {
					A[head] = A[tail];
					tail--;
					count--;
				}
			}
		}
		int[] B = new int[count];
		for (int i = 0; i < count; i++)
			B[i] = A[i];

		A = B;

		return count;
	}
}
