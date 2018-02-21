package me.xlui.data_structure.tree.impl;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 利用优先队列构造哈夫曼树
 */
public class HuffmanTree {
	private Node root;

	public HuffmanTree(int... elements) {
		Node parent = null;
		PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.key));
		// Comparator.comparingInt(lambda expression) 是创建一个比较器
		for (int element : elements) {
			queue.add(new Node(element));
		}
		while (queue.size() > 1) {
			// 当最后两个结点被取出计算 parent 后，parent 又放入队列中，此时应该停止循环。
			// 停止的条件就是 size > 1
			Node left = queue.poll();
			Node right = queue.poll();
			parent = new Node(left.key + right.key, left, right);
			queue.add(parent);
		}
		this.root = parent;
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

		public Node(int key) {
			this();
			this.key = key;
		}

		public Node(int key, Node left, Node right) {
			this.key = key;
			this.left = left;
			this.right = right;
		}
	}
}
