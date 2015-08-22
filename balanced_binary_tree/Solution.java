package kai.leetcode.algorithm.balanced_binary_tree;

//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		if (depth(root, 0) >= 0)
			return true;
		else
			return false;

	}

	public int depth(TreeNode node, int depth) {
		if (node == null)
			return depth;

		if (node.left == null && node.right == null)
			return depth + 1;
		else {
			int d1 = depth(node.left, depth);
			int d2 = depth(node.right, depth);
			if (d1 < 0 || d2 < 0 || d1 - d2 < -1 || d1 - d2 > 1)
				return -1;
			else {
				if (d2 > d1)
					return d2 + 1;
				else
					return d1 + 1;
			}
		}

	}
}