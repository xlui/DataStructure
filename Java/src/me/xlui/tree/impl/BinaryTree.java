package me.xlui.tree.impl;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 默认的树是：
 * <p>
 * A
 * B     C
 * D   F G   I
 * E   H
 */
public class BinaryTree {
	private Node root;

	public BinaryTree() {
		this.root = new Node();
		this.init();
	}

	private void init() {
		this.root.data = "A";


		this.root.left = new Node();
		this.root.left.data = "B";

		this.root.left.left = new Node();
		this.root.left.left.data = "D";

		this.root.left.right = new Node();
		this.root.left.right.data = "F";

		this.root.left.right.left = new Node();
		this.root.left.right.left.data = "E";


		this.root.right = new Node();
		this.root.right.data = "C";

		this.root.right.left = new Node();
		this.root.right.left.data = "G";

		this.root.right.right = new Node();
		this.root.right.right.data = "I";

		this.root.right.left.right = new Node();
		this.root.right.left.right.data = "H";
	}

	// 先序遍历
	public void preOrderTraversal() {
		preOrderTraversal(this.root);
	}

	// 实现
	private void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	// 中序遍历
	public void inOrderTraversal() {
		inOrderTraversal(this.root);
	}

	// 实现
	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	// 后序遍历
	public void postOrderTraversal() {
		postOrderTraversal(this.root);
	}

	// 实现
	private void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	/**
	 * 非递归实现的原理：
	 * 利用堆栈，每个节点保存在堆栈里，然后按照遍历的顺序依次取出
	 */
	// 先序遍历 -- 非递归
	public void preOrderStackTraversal() {
		Node node = this.root;
		Stack<Node> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			// node == null 说明到达最左边
			// stack 非空说明还有结点没遍历
			while (node != null) {
				System.out.print(node.data + " ");
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				node = node.right;
			}
		}
	}

	// 中序遍历 -- 非递归
	public void inOrderStackTraversal() {
		Node node = this.root;
		Stack<Node> stack = new Stack<>();
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
	}

	/**
	 * 层次遍历的原理：
	 * 利用队列，每次从队列里取出一个结点访问，然后将该结点的左右儿子（非空）放入队列。依次循环。
	 */
	// 层次遍历 -- 队列实现
	public void levelOrderTraversal() {
		Queue<Node> queue = new ArrayDeque<>();
		Node node;
		if (this.root == null)
			return;
		queue.add(this.root);
		while (!queue.isEmpty()) {
			node = queue.remove();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	// 输出叶子节点
	public void leaf() {
		this.leaf(this.root);
	}

	private void leaf(Node node) {
		if (node != null) {
			if (node.left == null && node.right == null) {
				System.out.print(node.data + " ");
			}
			this.leaf(node.left);
			this.leaf(node.right);
		}
	}

	// 求树的高度
	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		int highLeft, highRight;
		if (node != null) {
			highLeft = height(node.left);
			highRight = height(node.right);
			return (Math.max(highLeft, highRight) + 1);
		}
		return 0;
	}

	private class Node {
		private String data;
		private Node left;
		private Node right;

		public Node() {
			this.data = "";
			this.left = null;
			this.right = null;
		}

		public Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
