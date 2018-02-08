package me.xlui.stack.impl;

public class LinkedStack<E> implements Stack<E> {
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

	@Override
	public void push(E e) {
		if (this.top == null) {
			this.top = new Node<>(e);
			++this.size;
			return;
		}

		Node node = new Node<>(e);
		node.next = this.top;
		this.top = node;
		++this.size;
	}

	@SuppressWarnings("unchecked")
	public E pop() throws Exception {
		if (this.top == null) {
			throw new Exception("Stack is empty!");
		}
		E top = (E) this.top.data;
		this.top = this.top.next;
		--this.size;
		return top;
	}

	@SuppressWarnings("unchecked")
	public E peek() throws Exception {
		if (this.top == null) {
			throw new Exception("Stack is empty!");
		}
		return (E) this.top.data;
	}

	private static class Node<E> {
		private E data;
		private Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
