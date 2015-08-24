package kai.leetcode.algorithm.path_sum;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

// Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		boolean r1 = false;
		boolean r2 = false;
		if (root == null)
			return false;
		if (root.left != null)
			r1 = hasPathSum(root.left, sum - root.val);
		if (root.right != null)
			r2 = hasPathSum(root.right, sum - root.val);
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		else
			return r1 || r2;

	}
}