package kai.leetcode.algorithm.populating_next_right_pointers_in_each_node;

//Given a binary tree
//
//struct TreeLinkNode {
//  TreeLinkNode *left;
//  TreeLinkNode *right;
//  TreeLinkNode *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
//Note:
//
//You may only use constant extra space.
//You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
//For example,
//Given the following perfect binary tree,
//     1
//   /  \
//  2    3
// / \  / \
//4  5  6  7
//After calling your function, the tree should look like:
//     1 -> NULL
//   /  \
//  2 -> 3 -> NULL
// / \  / \
//4->5->6->7 -> NULL

//  Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode parent = root;
		TreeLinkNode curr = root.left;

		while (curr != null) {
			if (parent.right != curr) {
				curr.next = parent.right;
				curr = curr.next;
			} else {
				if (parent.next != null) {
					curr.next = parent.next.left;
					curr = curr.next;
					parent = parent.next;
				} else {
					break;
				}
			}
		}

		connect(root.left);
	}

}