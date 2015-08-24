package kai.leetcode.algorithm.sum_root_to_leaf_numbers;

//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//For example,
//
//    1
//   / \
//  2   3
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//
//Return the sum = 12 + 13 = 25.

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

	public int sumNumbers(TreeNode root) {

		if (root == null)
			return 0;

		return sum(root, 0);
	}

	public int sum(TreeNode root, int s) {
		if (root.left == null && root.right == null)
			return s + root.val;

		int r = 0;
		if (root.left != null)
			r = r + sum(root.left, (s + root.val) * 10);

		if (root.right != null)
			r = r + sum(root.right, (s + root.val) * 10);

		return r;

	}

}