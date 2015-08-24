package kai.leetcode.algorithm.set_matrix_zeroes;

import java.util.HashSet;

//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.


public class Solution {
	public void setZeroes(int[][] matrix) {
		if (matrix == null)
			return;

		int m = matrix.length;
		int n = 0;
		if (m > 0)
			n = matrix[0].length;
		else
			return;

		HashSet<Integer> mSet = new HashSet<Integer>();
		HashSet<Integer> nSet = new HashSet<Integer>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					mSet.add(i);
					nSet.add(j);
				}

			}
		}

		for (int i : mSet) {
			for (int j = 0; j < n; j++)
				matrix[i][j] = 0;
		}

		for (int j : nSet) {
			for (int i = 0; i < m; i++) {
				matrix[i][j] = 0;
			}

		}

	}
}