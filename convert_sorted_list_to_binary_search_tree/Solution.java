package kai.leetcode.algorithm.convert_sorted_list_to_binary_search_tree;

//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

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
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		int l = 1;
		ListNode n = head;
		while (n.next != null) {
			n = n.next;
			l++;
		}
		return find(head, l);

	}

	private TreeNode find(ListNode head, int len) {
		if (len == 1) {
			return new TreeNode(head.val);
		} else if (len > 1) {
			int mid = 0;
			if (len % 2 == 0) {
				mid = len / 2;
			} else {
				mid = len / 2 + 1;
			}
			TreeNode node = new TreeNode(next(head, mid).val);
			node.left = find(head, mid - 1);
			node.right = find(next(head, mid + 1), len / 2);
			return node;
		} else
			return null;
	}

	private ListNode next(ListNode head, int index) {
		for (int i = 1; i < index; i++) {
			head = head.next;
		}
		return head;
	}
}