package com.anuj.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxInABinaryTree {

	public int recursiveFindMaxInBinaryTree(TreeNode root) {
		int max = Integer.MIN_VALUE;

		if (root == null) {
			return 0;
		}

		int leftMax = recursiveFindMaxInBinaryTree(root.left);
		int rightMax = recursiveFindMaxInBinaryTree(root.right);

		max = leftMax > rightMax ? leftMax : rightMax;

		max = max > root.value ? max : root.value;

		return max;
	}

	public int iterativeFindMaxInBinaryTree(TreeNode root) {
		int max = Integer.MIN_VALUE;

		Queue<TreeNode> que = new LinkedList<TreeNode>();

		if (root == null) {
			return max;
		}

		que.offer(root);

		while (!que.isEmpty()) {
			TreeNode curr = que.poll();

			if (curr == null) {
				continue;
			}
			if (curr.value > max) {
				max = curr.value;
			}

			if (curr.left != null) {
				que.offer(curr.left);
			}
			if (curr.right != null) {
				que.offer(curr.right);
			}

		}

		return max;
	}
}
