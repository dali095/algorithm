package kai.leetcode.algorithm.distinct_subsequences;

import java.util.HashMap;
import java.util.Map;

//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"
//
//Return 3.

public class Solution {

	private Map<String, Integer> map = new HashMap<>();

	public int numDistinct(String S, String T) {
		if (S == null || T == null)
			return 0;
		else if (S.length() < T.length())
			return 0;
		if (T.length() == 0)
			return 1;

		int index = S.indexOf(T.charAt(0));
		if (index >= 0) {
			int i1 = 0;
			int i2 = 0;
			if (map.containsKey(S.substring(index + 1) + "," + T)) {
				i1 = map.get(S.substring(index + 1) + "," + T);
			} else {
				i1 = numDistinct(S.substring(index + 1), T);
				map.put(S.substring(index + 1) + "," + T, i1);
			}

			if (map.containsKey(S.substring(index + 1) + "," + T.substring(1))) {
				i2 = map.get(S.substring(index + 1) + "," + T.substring(1));
			} else {
				i2 = numDistinct(S.substring(index + 1), T.substring(1));
				map.put(S.substring(index + 1) + "," + T.substring(1), i2);
			}

			return i1 + i2;
		} else {
			return 0;
		}

	}
}
