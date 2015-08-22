package kai.leetcode.algorithm.binary_tree_preorder_traversal;

import java.util.ArrayList;

//Given a binary tree, return the preorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [1,2,3].
//
//Note: Recursive solution is trivial, could you do it iteratively?
//
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
	public ArrayList<Integer> preorderTraversal(TreeNode root) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;

		result.add(root.val);

		if (root.left != null) {
			result.addAll(preorderTraversal(root.left));
		}

		if (root.right != null) {
			result.addAll(preorderTraversal(root.right));
		}

		return result;
	}
}
