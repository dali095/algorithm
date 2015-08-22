package kai.leetcode.algorithm.happy_number;

import java.util.Set;

//Write an algorithm to determine if a number is "happy".
//
//A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//Example: 19 is a happy number
//
//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1

public class Solution {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (true) {
			String s = n + "";
			n = 0;
			for (int i = 0; i < s.length(); i++) {
				n = n + (s.charAt(i) - 48) * (s.charAt(i) - 48);
			}
			if (n == 1)
				return true;
			else if (set.contains(n))
				return false;
			else
				set.add(n);
		}

	}
}