package me.xlui.data_structure.stack;

/**
 * 栈 —— 链表实现
 */
@SuppressWarnings("unchecked")
public class LinkedStack<E> implements Stack<E> {
	private Node top = null;
	private int size = 0;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void push(E e) {
		Node node = new Node<>(e);
		node.next = this.top;
		this.top = node;
		this.size++;
	}

	@Override
	public E peek() throws Exception {
		if (this.top == null) {
			throw new Exception("Stack is empty!");
		}
		return (E) this.top.data;
	}

	@Override
	public E pop() throws Exception {
		if (this.top == null) {
			throw new Exception("Stack is empty!");
		}
		E top = (E) this.top.data;
		this.top = this.top.next;
		this.size--;
		return top;
	}

	private static class Node<E> {
		E data;
		Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
