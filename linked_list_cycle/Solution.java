package kai.leetcode.algorithm.linked_list_cycle;

import java.util.HashSet;
//
//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//Can you solve it without using extra space?

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		while (head != null) {
			if (set.contains(head)) {
				return true;
			} else {
				set.add(head);
				head = head.next;
			}
		}
		return false;
	}
}
