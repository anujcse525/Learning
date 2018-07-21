package com.ds.ll;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50, new ListNode(60, null))))));
		System.out.println(findMidNode(head).toString());
	}
	
	public static ListNode findMidNode(ListNode head){
		ListNode slow = head, fast = head;
		while(fast != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
