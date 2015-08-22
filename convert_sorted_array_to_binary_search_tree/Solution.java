package kai.leetcode.algorithm.convert_sorted_array_to_binary_search_tree;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;
		return f(num, 0, num.length - 1);
	}

	public TreeNode f(int[] num, int i, int j) {
		if (i < j) {
			int mid = 0;
			if ((i + j) % 2 == 0) {
				mid = (i + j) / 2;
				TreeNode n = new TreeNode(num[mid]);
				n.left = f(num, i, mid - 1);
				n.right = f(num, mid + 1, j);
				return n;
			} else {
				mid = (i + j) / 2 + 1;
				TreeNode n = new TreeNode(num[mid]);
				n.left = f(num, i, mid - 1);
				n.right = f(num, mid + 1, j);
				return n;
			}
		} else if (i == j) {
			return new TreeNode(num[i]);
		} else
			return null;
	}

}