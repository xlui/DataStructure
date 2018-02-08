package me.xlui.tree;

import me.xlui.tree.impl.BinarySearchTree;

public class Main {
	public static void main(String[] args) throws Exception {
		//	树结构：
		//		30
		//	  15  41
		//	     33 50
		BinarySearchTree tree = new BinarySearchTree();
		tree.inOrderTraversal();

		System.out.println("\n判断树中是否有 43 和 30：");
		System.out.println(tree.hasElement(43));
		System.out.println(tree.hasElementIter(30));
		System.out.println("查找树中最大值：");
		System.out.println(tree.findMax());
		System.out.println("查找树中最小值：");
		System.out.println(tree.findMin());

		System.out.println("插入元素 12：");
		tree.insert(12);
		tree.inOrderTraversal();

		System.out.println("\n删除元素 15：");
		tree.delete(15);
		tree.inOrderTraversal();
		tree.insert(15);

		System.out.println("\n删除元素 12：");
		tree.delete(12);
		tree.inOrderTraversal();
		tree.insert(12);

		System.out.println("\n删除元素 41：");
		tree.delete(41);
		tree.inOrderTraversal();
	}
}
