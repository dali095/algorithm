package kai.leetcode.algorithm.plus_one;

//Given a non-negative number represented as an array of digits, plus one to the number.
//
//The digits are stored such that the most significant digit is at the head of the list.

public class Solution {
	public int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0)
			return digits;

		boolean all9 = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				all9 = false;
				break;
			}
		}

		if (all9) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}

		int i = digits.length - 1;
		while (i >= 0) {
			if (digits[i] == 9) {
				digits[i] = 0;
				i--;
			} else {
				digits[i]++;
				break;
			}
		}
		return digits;

	}
}