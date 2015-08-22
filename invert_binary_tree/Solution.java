package kai.leetcode.algorithm.invert_binary_tree;
//
//My Submissions Question Solution 
//Invert a binary tree.
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//to
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//Trivia:
//This problem was inspired by this original tweet by Max Howell:
//Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
//
//

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;
		else if (root.left == null && root.right == null) {
			return root;
		} else {
			TreeNode tn = root.left;
			root.left = invertTree(root.right);
			root.right = invertTree(tn);
			return root;
		}

	}
}