package kai.leetcode.algorithm.partition_list;

//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.

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
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode n1 = null;
		ListNode n2 = null;
		ListNode head1 = null;
		ListNode head2 = null;

		while (head != null) {
			if (head.val < x) {
				if (n1 == null) {
					n1 = head;
					head1 = head;
					// n1.next = null;
				} else {
					n1.next = head;
					n1 = n1.next;
					// n1.next = null;
				}
			} else {
				if (n2 == null) {
					n2 = head;
					head2 = head;
					// n2.next = null;
				} else {
					n2.next = head;
					n2 = n2.next;
					// n2.next = null;
				}
			}
			head = head.next;
		}

		if (n2 != null)
			n2.next = null;

		if (head1 != null) {
			n1.next = head2;
			return head1;
		} else
			return head2;
	}
}
