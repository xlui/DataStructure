package me.xlui.data_structure.tree;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E extends Comparable> implements Tree<E> {
	private Node root;

	public BinarySearchTree() {
		this.insert((E) new Integer(30));
		this.insert((E) new Integer(15));
		this.insert((E) new Integer(41));
		this.insert((E) new Integer(33));
		this.insert((E) new Integer(50));
		/*
		 * 树结构：
		 *         30
		 *       15  41
		 *          33 50
		 */
	}

	public boolean hasElement(E element) {
		return this.find(this.root, element) != null;
	}

	public boolean hasElementIter(E element) {
		return this.findIter(this.root, element) != null;
	}

	public E findMax() throws Exception {
		Node node = this.findMax(this.root);
		if (node != null)
			return (E) node.data;
		else
			throw new Exception("BST is empty!");
	}

	public E findMin() throws Exception {
		Node node = this.findMin(this.root);
		if (node != null)
			return (E) node.data;
		else
			throw new Exception("BST is Empty!");
	}

	public void insert(E element) {
		this.root = this.insert(this.root, element);
	}

	public boolean delete(E element) {
		try {
			this.root = this.delete(this.root, element);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void preOrderTraversal() {
		this.preOrderTraversal(this.root);
	}

	@Override
	public void inOrderTraversal() {
		this.inOrderTraversal(this.root);
	}

	@Override
	public void postOrderTraversal() {
		this.postOrderTraversal(this.root);
	}

	@Override
	public void levelOrderTraversal() {

	}

	//**************************
	//   start private method
	//**************************

	/**
	 * 递归实现查找
	 */
	private Node find(Node node, E element) {
		if (node == null)
			return null;
		if (element.compareTo(node.data) > 0)
			return find(node.right, element);
		else if (element.compareTo(node.data) < 0)
			return find(node.left, element);
		else
			return node;
	}

	/**
	 * 迭代实现查找
	 */
	private Node findIter(Node node, E element) {
		while (node != null) {
			if (element.compareTo(node.data) > 0)
				node = node.right;
			else if (element.compareTo(node.data) < 0)
				node = node.left;
			else
				return node;
		}
		return null;
	}

	// 查找最大元素的迭代函数
	private Node findMax(Node node) {
		if (node != null)
			while (node.right != null)
				node = node.right;
		return node;
	}

	// 查找最小元素的递归函数
	private Node findMin(Node node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node;
		return findMin(node.left);
	}

	// 插入，并保证二叉搜索树有序。
	private Node insert(Node node, E element) {
		if (node == null) {
			// 结点为空，创建并插入数据
			node = new Node();
			node.data = element;
		} else {
			if (element.compareTo(node.data) > 0)
				node.right = insert(node.right, element);
			else if (element.compareTo(node.data) < 0)
				node.left = insert(node.left, element);
		}
		return node;
	}

	/**
	 * 分三种情况：
	 * 1、删除的结点是叶子节点。将其父结点的指针为 null
	 * 2、删除的结点只有一个儿子。将其父结点的指针指向要删除结点的儿子结点
	 * 3、删除的结点有两个儿子。用右子树的 最小元素 或者左子树的 最大元素 替代要删除的结点
	 */
	private Node delete(Node node, E element) throws Exception {
		if (node == null) {
			throw new Exception("Not Found!");
		} else if (element.compareTo(node.data) < 0) {
			node.left = delete(node.left, element);
		} else if (element.compareTo(node.data) > 0) {
			node.right = delete(node.right, element);
		} else {
			if (node.left != null && node.right != null) {
				// 要删除的结点有两个儿子结点
				Node tmp = findMin(node.right);    // 找到右子树的最小结点
				node.data = tmp.data;
				node.right = delete(node.right, (E) node.data);
			} else {
				node = (node.left != null) ? node.left : node.right;
			}
			/*
			if (node.left != null) {
				// 要删除的结点有左儿子结点
				node = node.left;
			} else if (node.right != null) {
				// 要删除的结点有右儿子结点
				node = node.right;
			} else {
				// 要删除的结点没有儿子结点
				node = null;
			}
			*/
		}

		return node;
	}

	private void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	private void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	private static final class Node<E> {
		E data;
		Node left;
		Node right;
	}
}
