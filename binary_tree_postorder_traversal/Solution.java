package kai.leetcode.algorithm.binary_tree_postorder_traversal;

import java.util.ArrayList;

//Given a binary tree, return the postorder traversal of its nodes' values.
//
//For example:
//Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
//return [3,2,1].

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

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		if (root.left != null)
			result.addAll(postorderTraversal(root.left));

		if (root.right != null)
			result.addAll(postorderTraversal(root.right));

		result.add(root.val);
		return result;
	}
}
