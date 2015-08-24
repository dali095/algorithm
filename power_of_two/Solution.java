package kai.leetcode.algorithm.power_of_two;
//Given an integer, write a function to determine if it is a power of two.
public class Solution {
	public boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;

		while (n > 1) {
			if (n % 2 != 0)
				return false;
			else
				n = n / 2;
		}
		return true;
	}
}
