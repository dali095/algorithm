package kai.leetcode.algorithm.spiral_matrix_ii;

//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]

public class Solution {
	public int[][] generateMatrix(int n) {
		if (n < 0)
			return null;

		int i = 0;
		int j = 0;

		int[][] result = new int[n][n];
		if (n == 0)
			return result;

		int count = 1;

		while (true) {

			while (j < n && result[i][j] == 0) {
				result[i][j] = count++;
				j++;
				if (count > n * n)
					return result;
			}
			j--;
			i++;

			while (i < n && result[i][j] == 0) {
				result[i][j] = count++;
				i++;
				if (count > n * n)
					return result;
			}
			i--;
			j--;

			while (j >= 0 && result[i][j] == 0) {
				result[i][j] = count++;
				j--;
				if (count > n * n)
					return result;
			}
			j++;
			i--;

			while (i >= 0 && result[i][j] == 0) {
				result[i][j] = count++;
				i--;
				if (count > n * n)
					return result;
			}
			i++;
			j++;
		}

	}
}
