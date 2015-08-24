package kai.leetcode.algorithm.symmetric_tree;

//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//For example, this binary tree is symmetric:
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//But the following is not:
//    1
//   / \
//  2   2
//   \   \
//   3    3
//Note:
//Bonus points if you could solve it both recursively and iteratively.

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
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		if (root.left == null && root.right == null) {
			return true;
		} else if (root.left == null || root.right == null) {
			return false;
		} else {
			return isSym(root.left, root.right);
		}
	}

	public boolean isSym(TreeNode lNode, TreeNode rNode) {

		if (lNode.val != rNode.val) {
			return false;
		}

		if (lNode.left == null) {
			if (rNode.right != null)
				return false;
		} else {
			if (rNode.right == null)
				return false;
			else {
				if (!isSym(lNode.left, rNode.right))
					return false;
			}
		}

		if (lNode.right == null) {
			if (rNode.left != null)
				return false;
		} else {
			if (rNode.left == null)
				return false;
			else {
				if (!isSym(lNode.right, rNode.left))
					return false;
			}
		}

		return true;
	}

}
