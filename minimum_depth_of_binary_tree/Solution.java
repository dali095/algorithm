package kai.leetcode.algorithm.minimum_depth_of_binary_tree;

//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int d = 1;

		return find(root, d);

	}

	private int find(TreeNode root, int d) {
		if (root.left == null && root.right == null) {
			return d;
		} else if (root.left != null && root.right != null) {
			int l = find(root.left, d + 1);
			int r = find(root.right, d + 1);
			if (l < r)
				return l;
			else
				return r;
		} else if (root.left != null) {
			return find(root.left, d + 1);
		} else {
			return find(root.right, d + 1);
		}

	}
}