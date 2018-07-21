package com.ds.ll;

public class ReverseLinkedList {

	public static void main(String[] args) {

		ListNode first = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50, null)))));
		displayList(first);
		ListNode[] head = new ListNode[1];
		reverseLinkedList(first,head);
		displayList(head[0]);
	}

	public static void reverseLinkedList(ListNode current, ListNode[] head) {
		if (current == null)
			return ;
		ListNode next = current.next;
		if(next == null){
			head[0] = current;
			return ;
		}
		reverseLinkedList(next, head);
		next.setNext(current);
		current.setNext(null);
	}
	
	public static void displayList(ListNode head) {
		while (head != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println();
	}

}


