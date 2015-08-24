package kai.leetcode.algorithm.search_a_2d_matrix_ii;

//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
//For example,
//
//Consider the following matrix:
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//Given target = 5, return true.
//
//Given target = 20, return false.

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return false;

		int m = matrix.length;
		int n = matrix[0].length;

		int mLow = 0;
		int mHigh = m - 1;
		int nLow = 0;
		int nHigh = n - 1;

		return find(matrix, 0, m - 1, 0, n - 1, target);

	}

	public boolean find(int[][] matrix, int mLow, int mHigh, int nLow,
			int nHigh, int target) {
		if (mLow > mHigh || nLow > nHigh)
			return false;

		int mMid = (mLow + mHigh) / 2;
		int nMid = (nLow + nHigh) / 2;

		if (matrix[mMid][nMid] == target)
			return true;
		else if (matrix[mMid][nMid] > target) {

			if (mLow == mHigh && nLow == nHigh)
				return false;
			return find(matrix, mLow, mMid, nLow, nMid, target)
					|| find(matrix, mMid + 1, mHigh, nLow, nMid, target)
					|| find(matrix, mLow, mMid, nMid + 1, nHigh, target);
		} else {

			if (mLow == mHigh && nLow == nHigh)
				return false;
			return find(matrix, mMid + 1, mHigh, nMid + 1, nHigh, target)
					|| find(matrix, mMid + 1, mHigh, nLow, nMid, target)
					|| find(matrix, mLow, mMid, nMid + 1, nHigh, target);
		}

	}
}