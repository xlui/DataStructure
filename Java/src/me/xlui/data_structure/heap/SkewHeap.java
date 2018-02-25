package me.xlui.data_structure.heap;

import me.xlui.data_structure.tree.Tree;

@SuppressWarnings("unchecked")
public class SkewHeap<T extends Comparable<T>> implements Heap<T>, Tree<T> {
	private Node<T> root;
	private int size;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	public void merge(SkewHeap<T> other) {
		this.root = this.merge(this.root, other.root);
	}

	@Override
	public void add(T t) {
		Node<T> node = new Node<>(t);
		this.root = this.merge(this.root, node);
		this.size++;
	}

	@Override
	public T remove() {
		if (this.root == null) {
			return null;
		}
		T key = this.root.key;
		Node<T> l = this.root.left;
		Node<T> r = this.root.right;
		this.root = this.merge(l, r);
		return key;
	}

	@Override
	public T peek() {
		return this.root.key;
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

		// 合并 x 和 y 时，将 x 作为合并后的树根
		if (x.key.compareTo(y.key) > 0) {
			Node<T> node = x;
			x = y;
			y = node;
		}

		// 将 x 的右孩子和 y 合并，合并后直接交换 x 的左右孩子
		Node tmp = merge(x.right, y);
		x.right = x.left;
		x.left = tmp;

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
		Node<T> left, right;

		public Node(T key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}
}
