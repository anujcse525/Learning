package com.anuj.tree;

public class PrintMirrorTree {

	public static void main(String[] args) {

		TreeNode root = TreeTraveralTest.createTree();

		System.out.println(root);

		root = getMirrorTree(root);

		System.out.println(root);
	}

	public static TreeNode getMirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		getMirrorTree(root.left);
		getMirrorTree(root.right);

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		return root;
	}

}
