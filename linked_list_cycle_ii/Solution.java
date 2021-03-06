package kai.leetcode.algorithm.linked_list_cycle_ii;

import java.util.HashSet;

//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//Note: Do not modify the linked list.
//
//Follow up:
//Can you solve it without using extra space?
//
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
	public ListNode detectCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		while (head != null) {
			if (set.contains(head)) {
				return head;
			} else {
				set.add(head);
				head = head.next;
			}
		}
		return head;
	}
}
