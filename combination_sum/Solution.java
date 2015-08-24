package kai.leetcode.algorithm.combination_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7, 
//A solution set is: 
//[7] 
//[2, 2, 3] 

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Arrays.sort(candidates);
		f(result, null, candidates, target, 0);
		return result;
	}

	public void f(List<List<Integer>> list, List<Integer> aList,
			int[] candidates, int target, int index) {
		if (aList == null)
			aList = new LinkedList<Integer>();
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] < target) {
				List<Integer> cloned = new LinkedList<Integer>();
				cloned.addAll(aList);
				cloned.add(candidates[i]);
				f(list, cloned, candidates, target - candidates[i], i);
			} else if (candidates[i] == target) {
				aList.add(candidates[i]);
				list.add(aList);
				break;
			}
		}
	}

}