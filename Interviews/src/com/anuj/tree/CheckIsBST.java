package com.anuj.tree;

class BinarySearchTreeNode {
	public int data;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode right;

	public BinarySearchTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BinarySearchTreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	
}

public class CheckIsBST {

	public static void main(String[] args) {
		BinarySearchTreeNode node = new BinarySearchTreeNode(6);
		BinarySearchTreeNode node1 = new BinarySearchTreeNode(2);
		BinarySearchTreeNode node2 = new BinarySearchTreeNode(1);
		BinarySearchTreeNode node3 = new BinarySearchTreeNode(5);
		BinarySearchTreeNode node4 = new BinarySearchTreeNode(8);
		node.setLeft(node1);
		node1.setLeft(node2);
		node1.setRight(node3);
		node.setRight(node4);

		System.out.println(isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static boolean isBST(BinarySearchTreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		return (root.data > min && root.data < max && isBST(root.left, min, root.data)
				&& isBST(root.right, root.data, max));
	}

}
