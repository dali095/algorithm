package kai.leetcode.algorithm.kth_smallest_element_in_a_bst;

//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

//  Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;

		int l = count(root.left);

		if (l < k - 1)
			return kthSmallest(root.right, k - l - 1);
		else if (l == k - 1)
			return root.val;
		else
			return kthSmallest(root.left, k);
	}

	public int count(TreeNode root) {
		if (root == null)
			return 0;
		return count(root.left) + count(root.right) + 1;
	}
}