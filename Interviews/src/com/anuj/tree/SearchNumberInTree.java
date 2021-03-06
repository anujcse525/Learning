package com.anuj.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchNumberInTree {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(null, null, 10);
		TreeNode node2 = new TreeNode(null, null, 20);
		TreeNode node3 = new TreeNode(null, null, 30);
		TreeNode node4 = new TreeNode(null, null, 40);
		TreeNode node5 = new TreeNode(null, null, 50);
		TreeNode node6 = new TreeNode(null, null, 60);
		TreeNode node7 = new TreeNode(null, null, 70);
		TreeNode node8 = new TreeNode(null, null, 80);
		TreeNode node9 = new TreeNode(null, null, 90);
		TreeNode node10 = new TreeNode(null, null, 100);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		node6.left = node10;
		
		System.out.println(findInBinaryTree(node1, 85));
		
		PrintTreeInReverseOrder.printTreeInReverse(node1);
	}

	public static boolean findInBinaryTree(TreeNode root, int num) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.value == num) {
				return true;
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

		return false;
	}
}
