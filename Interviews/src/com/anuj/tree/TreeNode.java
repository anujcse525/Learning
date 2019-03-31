package com.anuj.tree;

public class TreeNode {
	TreeNode left, right;
	int value;

	public TreeNode(int data) {
		this.value = data;
		this.right = this.left = null;
	}

	public TreeNode(TreeNode left, TreeNode right, int value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value + " > " + left + " > " + right;
	}

}
