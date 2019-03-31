package com.anuj.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

	public List<Integer> levelOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);

		queue.offer(null);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr != null) {
				result.add(curr.value);
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			} else {
				if (!queue.isEmpty())
					queue.offer(null);
			}
		}

		return result;
	}

	public List<Integer> reverseLevelOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		Queue<TreeNode> que = new LinkedList<TreeNode>();

		Stack<TreeNode> revStack = new Stack<TreeNode>();

		if (root == null) {
			return null;
		}

		que.offer(root);

		while (!que.isEmpty()) {
			TreeNode temp = que.poll();
			if (temp != null) {
				revStack.push(temp);
				if (temp.left != null)
					que.offer(temp.left);
				if (temp.right != null)
					que.offer(temp.right);
			}
		}

		while (!revStack.isEmpty())
			result.add(revStack.pop().value);

		return result;
	}
}
