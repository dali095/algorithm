package kai.leetcode.algorithm.binary_search_tree_iterator;

import java.util.Stack;

//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//
//Calling next() will return the next smallest number in the BST.
//
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

//  Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BSTIterator {
	Stack<TreeNode> s = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		while (root != null) {
			s.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode root = s.pop();
		TreeNode right = root.right;
		while (right != null) {
			s.push(right);
			right = right.left;
		}
		return root.val;
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
