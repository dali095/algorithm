package kai.leetcode.algorithm.combinations;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
//If n = 4 and k = 2, a solution is:
//
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]

public class Solution {
	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();

		if (k > n || n == 0 || k == 0)
			return result;

		for (int i = 0; i < n; i++) {
			List<Integer> l = new LinkedList<>();
			l.add(i + 1);
			result.add(l);
		}

		return add(result, n, k - 1);

	}

	private List<List<Integer>> add(List<List<Integer>> l, int n, int k) {
		if (k < 1)
			return l;

		List<List<Integer>> result = new LinkedList<List<Integer>>();
		Iterator<List<Integer>> it = l.iterator();
		while (it.hasNext()) {
			List<Integer> ll = it.next();
			int i = ll.get(ll.size() - 1) + 1;
			for (; i <= n; i++) {
				List<Integer> llCopy = new LinkedList<Integer>();
				llCopy.addAll(ll);
				llCopy.add(i);
				result.add(llCopy);
			}
		}
		return add(result, n, k - 1);
	}
}