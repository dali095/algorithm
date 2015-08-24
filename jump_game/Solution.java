package kai.leetcode.algorithm.jump_game;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
public class Solution {
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}

		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (max < i)
				return false;
			else if (max < A[i] + i)
				max = A[i] + i;
		}
		return true;

	}
}