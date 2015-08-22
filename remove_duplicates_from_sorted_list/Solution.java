package kai.leetcode.algorithm.remove_duplicates_from_sorted_list;

//  Definition for singly-linked list.
//  Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//  For example,
//  Given 1->1->2, return 1->2.
//  Given 1->1->2->3->3, return 1->2->3.

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;

		ListNode node = head;
		while (node != null) {
			while (node.next != null && node.next.val == node.val)
				node.next = node.next.next;
			node = node.next;
		}

		return head;
	}
}
