package com.anuj.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTreeTraversal {

	public List<Integer> recursiveTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			result.addAll(recursiveTraversal(root.left));
			result.addAll(recursiveTraversal(root.right));
			result.add(root.value);
		}
		return result;
	}

	public List<Integer> iterativeTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;

		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				}
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				}
			} else {
				result.add(curr.value);
				stack.pop();
			}
			prev = curr;
		}

		return result;
	}

}
