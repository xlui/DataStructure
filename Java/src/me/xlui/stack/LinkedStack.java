package me.xlui.stack;

public class LinkedStack {
	private Node top;
	private int size;

	public LinkedStack() {
		this.top = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void push(int element) {
		if (this.top == null) {
			this.top = new Node(element);
			++this.size;
			return;
		}

		Node node = new Node(element);
		node.next = this.top;
		this.top = node;
		++this.size;
	}

	public int pop() throws Exception {
		if (this.top == null) {
			throw new Exception("Stack is empty!");
		}
		int top = this.top.data;
		this.top = this.top.next;
		--this.size;
		return top;
	}

	public int get() throws Exception {
		if (this.top == null) {
			throw new Exception("Stack is empty!");
		}
		return this.top.data;
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
