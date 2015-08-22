package kai.leetcode.algorithm.merge_two_sorted_lists;

//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;

		ListNode result = null;
		if (l1.val < l2.val) {
			result = l1;
			l1 = l1.next;
		} else {
			result = l2;
			l2 = l2.next;
		}

		ListNode head = result;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				result.next = l1;
				l1 = l1.next;
				result = result.next;
			} else {
				result.next = l2;
				l2 = l2.next;
				result = result.next;
			}
		}

		if (l1 == null)
			result.next = l2;
		else
			result.next = l1;

		return head;
	}
}