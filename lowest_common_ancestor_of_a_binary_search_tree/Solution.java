package kai.leetcode.algorithm.lowest_common_ancestor_of_a_binary_search_tree;

//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______6______
//       /              \
//    ___2__          ___8__
//   /      \        /      \
//   0      _4       7       9
//         /  \
//         3   5
//For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


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
