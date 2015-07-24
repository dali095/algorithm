package kai.leetcode.algorithm.populating_next_right_pointers_in_each_node;

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