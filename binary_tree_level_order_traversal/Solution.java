package kai.leetcode.algorithm.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		traversal(root, 1, result);
		return result;

	}

	public void traversal(TreeNode root, int level, List<List<Integer>> result) {
		if (result.size() < level) {
			List<Integer> list = new ArrayList<>();
			result.add(list);
			list.add(root.val);
		} else {
			List<Integer> list = result.get(level - 1);
			list.add(root.val);
		}

		if (root.left != null)
			traversal(root.left, level + 1, result);
		if (root.right != null)
			traversal(root.right, level + 1, result);

	}
}