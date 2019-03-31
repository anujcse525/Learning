package com.anuj.tree;

import java.util.HashMap;
import java.util.Scanner;

public class HeightOfATree {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		while (testCases > 0) {
			HashMap<Integer, TreeNode> nodeMap = new HashMap<Integer, TreeNode>();

			int edges = scanner.nextInt();

			TreeNode root = null;

			while (edges > 0) {
				int node1 = scanner.nextInt();
				int node2 = scanner.nextInt();
				char lr = scanner.next().charAt(0);

				TreeNode parent = nodeMap.get(node1);

				if (parent == null) {
					parent = new TreeNode(node1);
					nodeMap.put(node1, parent);
					if (root == null) {
						root = parent;
					}
				}

				TreeNode child = new TreeNode(node2);

				if (lr == 'L') {
					parent.left = child;
				} else
					parent.right = child;

				nodeMap.put(node2, child);
				
				edges--;
			}

			System.out.println(root);
			System.out.println(getHeight(root));

			testCases--;
		}
	}

	public static int getHeight(TreeNode root) {

		if (root == null)
			return 0;

		int lDepth = getHeight(root.left);
		int rDepth = getHeight(root.right);

		if (lDepth > rDepth) {
			return lDepth + 1;
		} else {
			return rDepth + 1;
		}
	}
	
	public static void printMirror(TreeNode node){
		TreeNode mirrorRoot = null;
		
		if(node.left == null && node.right == null){
			System.out.println(node);
		}
		
		while(node != null){
			
		}
	}

}
