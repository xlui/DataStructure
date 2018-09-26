package algorithm;

public class RebuildBinarySearchTree {
	// 从先序遍历、中序遍历数组构建二叉树
	private Node fromPreIn(int[] pre, int beginPre, int endPre, int[] in, int beginIn, int endIn) {
		Node root = new Node(pre[beginPre]);
		// end
		if (beginPre == endPre) {
			if (beginIn == endIn && pre[beginPre] == in[beginIn]) {
				return root;
			} else {
				throw new RuntimeException("Invalid input!");
			}
		}

		int rootIndex = beginIn;    // find root index in in-order traversal
		while (rootIndex <= endIn && in[rootIndex] != root.value)
			rootIndex++;
		if (rootIndex == endIn && in[rootIndex] != root.value) {
			throw new RuntimeException("Invalid input!");
		}

		int leftSubtreeLength = rootIndex - beginIn;
		int leftPreorderEnd = beginPre + leftSubtreeLength;
		if (leftSubtreeLength > 0) {
			root.left = fromPreIn(pre, beginPre + 1, leftPreorderEnd, in, beginIn, rootIndex - 1);
		}
		if (leftSubtreeLength < endPre - beginPre) {
			root.right = fromPreIn(pre, leftPreorderEnd + 1, endPre, in, rootIndex + 1, endIn);
		}
		return root;
	}

	// 从后序遍历、中序遍历数组构建二叉树
	private Node fromPostIn(int[] post, int beginPost, int endPost, int[] in, int beginIn, int endIn) {
		Node root = new Node(post[endPost]);
		if (beginPost == endPost) {
			if (beginIn == endIn && post[beginPost] == in[beginIn]) {
				return root;
			} else {
				throw new RuntimeException("Invalid input!");
			}
		}

		int rootIndex = beginIn;
		while (rootIndex <= endIn && in[rootIndex] != root.value)
			rootIndex++;
		if (rootIndex == endIn && in[rootIndex] != root.value)
			throw new RuntimeException("Invalid input!");

		int rightSubtreeLength = endIn - rootIndex;
		int rightPostOrderStart = endPost - rightSubtreeLength;
		if (rightSubtreeLength > 0) {
			root.right = fromPostIn(post, rightPostOrderStart, endPost - 1, in, rootIndex + 1, endIn);
		}
		if (rightSubtreeLength < endPost - beginPost) {
			root.left = fromPostIn(post, beginPost, rightPostOrderStart - 1, in, beginIn, rootIndex - 1);
		}
		return root;
	}

	// 从数组构建二叉树
	private Node fromArray(int[] tree, int index) {
		Node root = null;
		if (index < tree.length) {
			root = new Node(tree[index]);
			root.left = fromArray(tree, 2 * index + 1);
			root.right = fromArray(tree, 2 * index + 2);
		}
		return root;
	}

	public static void main(String[] args) {
		RebuildBinarySearchTree rbst = new RebuildBinarySearchTree();
		/*
		 * 			10
		 * 		-2		6
		 * 	   8 -4    7 5
		 */
		int[] pre = {10, -2, 8, -4, 6, 7, 5};
		int[] in = {8, -2, -4, 10, 7, 6, 5};
		int[] post = {8, -4, -2, 7, 5, 6, 10};
		int[] tree = {10, -2, 6, 8, -4, 7, 5};
//		Node root = rbst.fromPreIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
//		Node root = rbst.fromPostIn(post, 0, post.length - 1, in, 0, in.length - 1);
		Node root = rbst.fromArray(tree, 0);
		output(root);
	}

	private static void output(Node root) {
		System.out.println("Pre Order:");
		_pre(root);
		System.out.println("\nIn Order:");
		_in(root);
		System.out.println("\nPost Order:");
		_post(root);
		System.out.println();
	}

	private static void _pre(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			_pre(root.left);
			_pre(root.right);
		}
	}

	private static void _in(Node root) {
		if (root != null) {
			_in(root.left);
			System.out.print(root.value + " ");
			_in(root.right);
		}
	}

	private static void _post(Node root) {
		if (root != null) {
			_post(root.left);
			_post(root.right);
			System.out.print(root.value + " ");
		}
	}

	private class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}
	}
}
