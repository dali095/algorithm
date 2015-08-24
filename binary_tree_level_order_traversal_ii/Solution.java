package kai.leetcode.algorithm.binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]

//  Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> l = new ArrayList<List<Integer>>();
		int level = 1;
		if (root == null)
			return l;
		inOrder(root, level, l);

		for (int i = 0; i < l.size() / 2; i++) {
			List<Integer> t = l.get(i);
			l.set(i, l.get(l.size() - i - 1));
			l.set(l.size() - i - 1, t);
		}

		return l;
	}

	private void inOrder(TreeNode root, int level, List<List<Integer>> l) {

		List<Integer> ar = null;
		if (l.size() < level) {
			ar = new ArrayList<Integer>();
			l.add(ar);
		} else
			ar = l.get(level - 1);

		ar.add(root.val);

		if (root.left != null)
			inOrder(root.left, level + 1, l);
		if (root.right != null)
			inOrder(root.right, level + 1, l);

	}
}
