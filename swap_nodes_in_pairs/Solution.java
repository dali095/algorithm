package kai.leetcode.algorithm.swap_nodes_in_pairs;

//
//Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
	public ListNode swapPairs(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode n1 = head;
		ListNode n2 = head.next;

		ListNode result = n2;
		ListNode previous = null;

		while (n1 != null && n2 != null) {
			ListNode n = n2.next;

			n1.next = n;
			n2.next = n1;

			if (previous != null) {
				previous.next = n2;
			}
			previous = n1;

			n1 = n;
			if (n1 != null)
				n2 = n1.next;
		}

		return result;

	}
}
