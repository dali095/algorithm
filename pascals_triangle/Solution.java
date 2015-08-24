package kai.leetcode.algorithm.pascals_triangle;

import java.util.ArrayList;

//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
public class Solution {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows == 0)
			return result;

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		result.add(arr);
		if (numRows == 1) {
			return result;
		}

		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> newRow = new ArrayList<Integer>();
			newRow.add(1);
			for (int j = 1; j < i; j++) {
				newRow.add(arr.get(j - 1) + arr.get(j));
			}
			newRow.add(1);
			arr = newRow;
			result.add(arr);
		}
		return result;

	}
}
