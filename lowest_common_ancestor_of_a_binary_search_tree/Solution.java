package kai.leetcode.algorithm.lowest_common_ancestor_of_a_binary_search_tree;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return root;
		if (root.left != null && hasNode(root.left, p) && hasNode(root.left, q))
			return lowestCommonAncestor(root.left, p, q);
		if (root.right != null && hasNode(root.right, p)
				&& hasNode(root.right, q))
			return lowestCommonAncestor(root.right, p, q);
		return root;
	}

	private boolean hasNode(TreeNode root, TreeNode node) {
		if (root == node)
			return true;
		else if (root.left != null && hasNode(root.left, node))
			return true;
		else if (root.right != null && hasNode(root.right, node))
			return true;
		return false;
	}
}
