package kai.leetcode.algorithm.triangle;

import java.util.ArrayList;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//Note:
//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null | triangle.size() == 0)
			return 0;

		if (triangle.size() == 1) {
			ArrayList<Integer> arr = triangle.get(0);
			return arr.get(0);
		}
		ArrayList<Integer> bottom = triangle.get(triangle.size() - 1);
		for (int i = triangle.size() - 2; i > -1; i--) {
			ArrayList<Integer> arr = triangle.get(i);
			for (int j = 0; j < arr.size(); j++) {
				if (bottom.get(j) < bottom.get(j + 1)) {
					arr.set(j, arr.get(j) + bottom.get(j));
				} else {
					arr.set(j, arr.get(j) + bottom.get(j + 1));
				}
			}
			bottom = arr;
		}

		return bottom.get(0);
	}
}