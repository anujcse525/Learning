package com.anuj.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintTreeInReverseOrder {

	public static void main(String[] args) {

	}

	public static void printTreeInReverse(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		que.offer(root);

		while (!que.isEmpty()) {
			TreeNode temp = que.poll();

			if (temp.left != null) {
				que.offer(temp.left);
			}
			if (temp.right != null) {
				que.offer(temp.right);
			}

			stack.add(temp);
		}
		
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.println(temp.value + " --> ");
		}
	}

}
