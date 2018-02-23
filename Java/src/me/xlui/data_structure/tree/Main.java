package me.xlui.data_structure.tree;

public class Main {
	public static void main(String[] args) throws Exception {
//		testBinaryTree();
//		testCompleteBinaryTree();
		testBinarySearchTree();
	}

	private static void testBinarySearchTree() throws Exception {
		/*
		 * 初始树结构：
		 *     30
		 *   15  41
		 *      33 50
		 */
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		System.out.println("前序遍历：");
		tree.preOrderTraversal();

		System.out.println("\n中序遍历：");
		tree.inOrderTraversal();

		System.out.println("\n后序遍历：");
		tree.postOrderTraversal();

		System.out.println("\n插入 12、16 后进行前序遍历：");
		tree.insert(16);
		tree.insert(12);
		tree.preOrderTraversal();

		System.out.println("\n删除 15 后进行前序遍历：");
		tree.delete(15);
		tree.preOrderTraversal();

		System.out.println("\n最大值：" + tree.findMax());
		System.out.println("最小值：" + tree.findMin());
		System.out.println("是否含有 41：" + tree.hasElement(41));
		System.out.println("是否含有 32：" + tree.hasElementIter(32));
	}

	private static void testCompleteBinaryTree() {
		CompleteBinaryTree<String> tree = new CompleteBinaryTree<>("A", "B", "O", "C", "S", "M", "Q", "W", "K");
		System.out.println("完全二叉树层次遍历：");
		tree.levelOrderTraversal();
	}

	private static void testBinaryTree() {
		BinaryTree<Integer> tree = new BinaryTree<>();
		System.out.println("前序遍历：");
		tree.preOrderTraversal();
		System.out.println("\n中序遍历：");
		tree.inOrderTraversal();
		System.out.println("\n后序遍历：");
		tree.postOrderTraversal();
		System.out.println("\n层次遍历：");
		tree.levelOrderTraversal();
		System.out.println("\n叶子结点：");
		tree.leaf();
		System.out.println("\n树的高度：" + tree.height());
	}
}
