package me.xlui.data_structure.tree;

public class Main {
	public static void main(String[] args) throws Exception {
//		testBinaryTree();
//		testCompleteBinaryTree();
//		testBinarySearchTree();
//		testAVLTree();
		testSplayTree();
	}

	private static void testSplayTree() {
		SplayTree<Integer> tree = new SplayTree<>();
		tree.insert(4);
		// 4
		tree.insert(2);
		//  4  => 2
		// 2       4
		tree.insert(3);
		// 2       2        3
		//  4  =>   3   => 2 4
		// 3         4
		tree.insert(-7);
		//   3      2       -7
		//  2 4 =>-7 3  =>    2
		//-7          4        3
		//                      4

		System.out.println("先序遍历：");
		tree.preOrderTraversal();
		System.out.println("\n中序遍历：");
		tree.inOrderTraversal();
		System.out.println("\n后序遍历：");
		tree.postOrderTraversal();

		tree.remove(2);
		System.out.println("\n删除 2 后先序遍历：");
		tree.preOrderTraversal();
		System.out.println("\n删除 2 后中序遍历：");
		tree.inOrderTraversal();
		System.out.println("\n删除 2 后后序遍历：");
		tree.postOrderTraversal();
	}

	private static void testAVLTree() throws Exception {
		AVLTree<Integer> tree = new AVLTree<>();
		tree.insert(3);
		// 3
		tree.insert(2);
		//  3
		// 2
		tree.insert(1);
		//   3       2
		//  2   =>  1 3
		// 1
		tree.insert(4);
		//  2
		// 1 3
		//    4
		tree.insert(5);
		//  2           2
		// 1 3    =>  1   4
		//    4          3 5
		//     5
		tree.insert(6);
		//   2          4
		// 1   4  =>  2   5
		//    3 5    1 3   6
		//       6
		tree.insert(7);
		//   4          4
		// 2   5  =>  2   6
		//1 3   6    1 3 5 7
		//       7
		System.out.println("前序遍历：");
		tree.preOrderTraversal();
		// 4 2 1 3 6 5 7
		System.out.println("\n中序遍历：");
		tree.inOrderTraversal();
		// 1 2 3 4 5 6 7
		System.out.println("\n后序遍历：");
		tree.postOrderTraversal();
		// 1 3 2 5 7 6 4

		//   4
		// 2   6
		//1 3 5 7
		tree.remove(5);
		//   4
		// 2   6
		//1 3   7
		tree.remove(6);
		//   4
		// 2   7
		//1 3
		tree.remove(7);
		//  4       2
		// 2   => 1   4
		//1 3        3
		System.out.println("\n删除5，6，7后前序遍历：");
		tree.preOrderTraversal();
		// 2 1 4 3
		System.out.println("\n删除5，6，7后中序遍历：");
		tree.inOrderTraversal();
		// 1 2 3 4
		System.out.println("\n删除5，6，7后后序遍历：");
		tree.postOrderTraversal();
		// 1 3 4 2
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
