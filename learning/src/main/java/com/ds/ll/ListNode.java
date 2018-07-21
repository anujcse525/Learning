package com.ds.ll;

public class ListNode {
	int data;
	ListNode next;

	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + "]";
	}

	

}
