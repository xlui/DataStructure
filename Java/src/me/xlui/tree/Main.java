package me.xlui.tree;

import me.xlui.tree.impl.HuffmanTree;

public class Main {
	public static void main(String[] args) {
		int a[] = {5, 6, 8, 7, 15};
		HuffmanTree tree = new HuffmanTree(a);
		tree.preOrderTraversal();
		System.out.println();
		tree.inOrderTraversal();
		System.out.println();
		tree.postOrderTraversal();
	}
}
