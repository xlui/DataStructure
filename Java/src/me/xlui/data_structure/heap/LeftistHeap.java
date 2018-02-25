package me.xlui.data_structure.heap;

import me.xlui.data_structure.tree.Tree;

@SuppressWarnings("unchecked")
public class LeftistHeap<T extends Comparable<T>> implements Heap<T>, Tree<T> {
	private Node root;
	private int size;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void add(T t) {
		Node<T> node = new Node<>(t, null, null);
		this.root = this.merge(this.root, node);
		this.size++;
	}

	@Override
	public T remove() {
		if (this.root == null) {
			return null;
		}

		T key = (T) this.root.key;
		Node<T> l = this.root.left;
		Node<T> r = this.root.right;
		this.root = this.merge(l, r);
		this.size--;
		return key;
	}

	public void merge(LeftistHeap<T> other) {
		this.root = this.merge(this.root, other.root);
	}

	@Override
	public T peek() {
		return (T) this.root.key;
	}

	@Override
	public T poll() {
		return this.remove();
	}

	@Override
	public void preOrderTraversal() {
		this.preOrderTraversal(this.root);
		System.out.println();
	}

	@Override
	public void inOrderTraversal() {
		this.inOrderTraversal(this.root);
		System.out.println();
	}

	@Override
	public void postOrderTraversal() {
		this.postOrderTraversal(this.root);
		System.out.println();
	}

	private Node merge(Node<T> x, Node<T> y) {
		if (x == null) {
			return y;
		}
		if (y == null) {
			return x;
		}

		// 合并 x 和 y 时，将 x 作为合并后的根
		if (x.key.compareTo(y.key) > 0) {
			Node node = x;
			x = y;
			y = node;
		}

		// 将 x 的右孩子和 y 合并，**合并后树的根**是 x 的右孩子
		x.right = this.merge(x.right, y);

		// 如果 x 的左孩子为空或者 x 的左孩子的 npl < 右孩子的 npl
		// 交换左右孩子
		if (x.left == null || x.left.npl < x.right.npl) {
			Node node = x.left;
			x.left = x.right;
			x.right = node;
		}
		if (x.right == null || x.left == null) {
			// 如果为叶子结点，则 npl 为 0
			x.npl = 0;
		} else {
			// 否则，npl 为
			x.npl = x.left.npl > x.right.npl ? x.right.npl + 1 : x.left.npl + 1;
		}
		return x;
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

	private static final class Node<T extends Comparable<T>> {
		T key;
		int npl;
		Node left, right;

		public Node(T key, Node left, Node right) {
			this.key = key;
			this.npl = 0;
			this.left = left;
			this.right = right;
		}
	}
}
