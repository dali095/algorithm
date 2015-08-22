package kai.leetcode.algorithm.reverse_linked_list;

//Reverse a singly linked list.

//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode before = null;
		ListNode tmp = head;
		while (tmp != null) {
			ListNode next = tmp.next;
			tmp.next = before;
			before = tmp;
			tmp = next;
		}
		head = before;
		return head;
	}
}