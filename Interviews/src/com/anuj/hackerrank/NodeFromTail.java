package com.anuj.hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class NodeFromTail {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	// Complete the getNode function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static int getNode(SinglyLinkedListNode head, int positionFromTail) {

		SinglyLinkedListNode presentNode = head, tempNode = head;

		for (int i = 0; i < positionFromTail; i++) {
			tempNode = tempNode.next;
		}

		while (tempNode.next != null) {
			presentNode = presentNode.next;
			tempNode = tempNode.next;
		}
		return presentNode.data;

	}

	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
		HashSet<Integer> set = new HashSet<Integer>();
		SinglyLinkedListNode temp = head, prev ;
		while(temp.next != null){
			if(!set.add(temp.data)){
				
			}
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int tests = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int testsItr = 0; testsItr < tests; testsItr++) {
			SinglyLinkedList llist = new SinglyLinkedList();

			int llistCount = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < llistCount; i++) {
				int llistItem = scanner.nextInt();
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				llist.insertNode(llistItem);
			}

			int position = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int result = getNode(llist.head, position);

			System.out.println(result);
			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		// bufferedWriter.close();

		scanner.close();
	}
}
