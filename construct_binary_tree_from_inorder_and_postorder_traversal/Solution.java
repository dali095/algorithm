package kai.leetcode.algorithm.construct_binary_tree_from_inorder_and_postorder_traversal;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.

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
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0)
			return null;

		int midNum = postorder[postorder.length - 1];
		int midIndex = find(inorder, midNum);

		TreeNode node = new TreeNode(midNum);

		int[] leftArrIn = new int[midIndex];
		for (int i = 0; i < midIndex; i++) {
			leftArrIn[i] = inorder[i];
		}
		int[] leftArrPost = new int[midIndex];
		for (int i = 0; i < midIndex; i++) {
			leftArrPost[i] = postorder[i];
		}
		node.left = buildTree(leftArrIn, leftArrPost);

		int[] rightArrIn = new int[inorder.length - midIndex - 1];
		int j = 0;
		for (int i = midIndex + 1; i < inorder.length; i++) {
			rightArrIn[j++] = inorder[i];
		}
		int[] rightArrPost = new int[rightArrIn.length];
		j = 0;
		for (int i = midIndex; i < postorder.length - 1; i++) {
			rightArrPost[j++] = postorder[i];
		}
		node.right = buildTree(rightArrIn, rightArrPost);

		return node;
	}

	private int find(int[] tree, int num) {
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] == num)
				return i;
		}
		return -1;
	}

}