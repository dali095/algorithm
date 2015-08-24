package kai.leetcode.algorithm.remove_nth_node_from_end_of_list;

//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.

//  Definition for singly-linked list. 
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;

		ListNode result = head;
		for (int i = 0; i < n - 1; i++) {
			head = head.next;
		}

		ListNode node = result;

		if (head.next == null) {
			result = result.next;
			return result;
		} else {
			head = head.next;
		}

		while (head.next != null) {
			node = node.next;
			head = head.next;
		}
		node.next = node.next.next;
		return result;

	}
}
