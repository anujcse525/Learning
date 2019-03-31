package com.anuj.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTreeTraversal {

	public List<Integer> recursiveTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		
		if(root == null){
			return result;
		}
		
		result.addAll(recursiveTraversal(root.left));
		result.add(root.value);
		result.addAll(recursiveTraversal(root.right));
		
		return result;
	}

	public List<Integer> iterativeTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root == null){
			return result;
		}
		
		boolean done = false;
		TreeNode current = root;
		while(!done){
			if(current != null){
				stack.push(current);
				current = current.left;
			}
			else{
				if(stack.isEmpty()){
					done = true;
				}
				else{
					current = stack.pop();
					result.add(current.value);
					current = current.right;
				}
			}
		}
		
		return result;
	}
	
	
}
