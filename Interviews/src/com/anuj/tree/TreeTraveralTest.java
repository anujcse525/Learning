package com.anuj.tree;

import java.util.List;

public class TreeTraveralTest {

	public static void main(String[] args) {

		TreeNode root = createTree();
		System.out.println(root);

		System.out.println(
				"------------------------------------------\n        InOrder Traversal         \n------------------------------------------");
		InOrderTreeTraversal inOrderTreeTraversal = new InOrderTreeTraversal();

		List<Integer> list = inOrderTreeTraversal.recursiveTraversal(root);

		displayTree(list);

		list = inOrderTreeTraversal.iterativeTraversal(root);

		displayTree(list);
		System.out.println(
				"------------------------------------------\n        PreOrder Traversal         \n------------------------------------------");

		PreOrderTreeTraversal preOrderTraversal = new PreOrderTreeTraversal();

		list = preOrderTraversal.recursivePreOrderTreeTraversal(root);
		displayTree(list);

		preOrderTraversal.iterativePreOrderTreeTraversal(root);
		displayTree(list);

		System.out.println(
				"------------------------------------------\n        PostOrder Traversal         \n------------------------------------------");

		PostOrderTreeTraversal postOrderTraversal = new PostOrderTreeTraversal();

		list = postOrderTraversal.recursiveTraversal(root);
		displayTree(list);

		list = postOrderTraversal.iterativeTraversal(root);
		displayTree(list);

		System.out.println(
				"------------------------------------------\n        LevelOrder Traversal         \n------------------------------------------");

		LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
		list = levelOrderTraversal.levelOrderTraversal(root);
		displayTree(list);

		list = levelOrderTraversal.reverseLevelOrderTraversal(root);
		displayTree(list);

		System.out.println(
				"------------------------------------------\n        Max in Given Tree         \n------------------------------------------");

		FindMaxInABinaryTree findMax = new FindMaxInABinaryTree();
		System.out.println(findMax.recursiveFindMaxInBinaryTree(root));
		System.out.println(findMax.iterativeFindMaxInBinaryTree(root));
	}

	public static TreeNode createTree() {
		TreeNode root = new TreeNode(10);
		TreeNode l1 = new TreeNode(20);
		TreeNode r1 = new TreeNode(30);
		TreeNode l2 = new TreeNode(40);
		TreeNode r2 = new TreeNode(50);
		TreeNode l3 = new TreeNode(60);
		TreeNode r3 = new TreeNode(70);
		TreeNode l4 = new TreeNode(80);
		TreeNode r4 = new TreeNode(90);
		TreeNode l5 = new TreeNode(100);
		TreeNode r5 = new TreeNode(110);
		TreeNode l6 = new TreeNode(120);
		TreeNode r6 = new TreeNode(130);

		root.left = l1;
		root.right = r1;
		l1.left = l2;
		l1.right = r2;
		r1.left = l3;
		r1.right = r3;

		/*
		 * l2.left = l4; l2.right = r4; r2.left = l5; r2.right = r5; r3.left =
		 * l6; r3.right = r6;
		 */

		return root;
	}

	public static void displayTree(List<Integer> list) {
		for (Integer temp : list) {
			System.out.print(temp + " > ");
		}
		System.out.println();
	}

}
