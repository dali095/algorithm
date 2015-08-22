package kai.leetcode.algorithm.find_minimum_in_rotated_sorted_array;

//
//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//You may assume no duplicate exists in the array.

public class Solution {
	public int findMin(int[] num) {
		if (num.length == 1)
			return num[0];

		return find(num, 0, num.length - 1);
	}

	public int find(int[] num, int i, int j) {
		if (i >= j)
			return num[i];
		if (num[i] < num[j])
			return num[i];
		else {
			return (find(num, i, (i + j) / 2) < find(num, (i + j) / 2 + 1, j)) ? find(
					num, i, (i + j) / 2) : find(num, (i + j) / 2 + 1, j);
		}
	}
}
