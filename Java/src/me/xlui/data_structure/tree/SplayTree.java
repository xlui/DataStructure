package me.xlui.data_structure.tree;

/**
 * Unchecked Splay Tree
 * 每次插入删除都进行旋转。对于插入，将新增的结点旋转为根。对于删除，如果被删除结点右左儿子，将其作为新的根；如果没有，将右儿子作为新的根。
 * 旋转使用了新的算法，见函数。
 */
public class SplayTree {
	private Node root;

	public SplayTree() {
		this.root = null;
	}

	public void insert(int key) {
		// 先将结点正常插入伸展树
		this.root = this.insert(this.root, key);
		// 将插入的结点旋转为树的根
		this.root = this.splay(this.root, key);
	}

	public void remove(int key) {
		this.remove(this.root, key);
	}

	public void preOrderTraversal() {
		this.preOrderTraversal(this.root);
	}

	public void inOrderTraversal() {
		this.inOrderTraversal(this.root);
	}

	public void postOrderTraversal() {
		this.postOrderTraversal(this.root);
	}

	// ********************
	//    private method
	// ********************
	private Node insert(Node node, int key) {
		if (node == null) {
			node = new Node();
			node.key = key;
		} else if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		} else {
			System.out.println("不允许插入相同结点！");
		}
		return node;
	}

	/**
	 * 首先将要删除的结点旋转为根节点。
	 * 如果结点存在左儿子，左旋将左儿子旋转为新的根，删除右儿子
	 * 如果结点没有左儿子，右旋将右儿子旋转为新的根，删除右儿子
	 */
	private void remove(Node node, int key) {
		node = splay(node, key);
		if (node.left != null) {
			this.root = rightRotation(node);
			this.root.right = this.root.right.right;
		} else {
			this.root.right = this.root.right.right;
		}
	}

	/**
	 * 这种算法的思想是：通过递归调用，每次检查根节点是不是要查找的值。是就返回，不是就进行对应的旋转。
	 * 举个例子：对于 key < node.key 的情况，如果 node 没有左儿子，说明查找到了尽头，返回 node；
	 * 如果 node 有左儿子，说明可以继续往下查找，进行一次左旋转（将左儿子旋转为新的根），然后递归调用。
	 */
	private Node splay(Node node, int key) {
		if (key < node.key) {
			if (node.left == null)
				// 如果当前结点没有左儿子，说明不存在值为 key 的结点，将当前结点返回作为根。
				return node;
			else {
				// 如果有，则说明还需继续往左查找。左旋转一次，然后递归调用 splay 函数。
				node = rightRotation(node);
				return splay(node, key);
			}
		} else if (key > node.key) {
			if (node.right == null)
				// 如果当前结点没有右儿子，说明不存在值为 key 的结点，将当前结点返回作为根。
				return node;
			else {
				// 如果有，则说明还需继续往右查找。右旋转一次，然后递归调用 splay 函数。
				node = leftRotation(node);
				return splay(node, key);
			}
		} else {
			// 如果找到，将其返回作为根。我们之所以直接返回，是因为在查找的过程中我们已经对该结点往上的结点进行过旋转。
			return node;
		}
	}

	private Node rightRotation(Node node) {
		Node tmp = node.left;
		node.left = tmp.right;
		tmp.right = node;
		return tmp;
	}

	private Node leftRotation(Node node) {
		Node tmp = node.right;
		node.right = tmp.left;
		tmp.left = node;
		return tmp;
	}

	private void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.key + " ");
			inOrderTraversal(node.right);
		}
	}

	private void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.key + " ");
		}
	}

	private static class Node {
		private int key;
		private Node left;
		private Node right;

		public Node() {
			this.left = null;
			this.right = null;
		}
	}
}
