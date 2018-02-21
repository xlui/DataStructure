package me.xlui.data_structure.stack.impl;

public class ArrayStack<E> implements Stack<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] data;
	private int top = -1;

	public ArrayStack() {
		this.data = new Object[DEFAULT_CAPACITY];
	}

	public ArrayStack(int size) {
		this.data = new Object[size];
	}

	public int size() {
		return top != -1 ? top + 1 : 0;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public void push(E e) throws Exception {
		if (top == DEFAULT_CAPACITY - 1) {
			throw new Exception("Stack is full!");
		}
		this.data[++this.top] = e;
	}

	@SuppressWarnings("unchecked")
	public E pop() throws Exception {
		if (top == -1) {
			throw new Exception("Stack is empty!");
		}
		return (E) this.data[this.top--];
	}

	@SuppressWarnings("unchecked")
	public E peek() throws Exception {
		if (this.top == -1) {
			throw new Exception("Stack is empty!");
		}
		return (E) this.data[this.top];
	}
}
