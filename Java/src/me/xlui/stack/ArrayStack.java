package me.xlui.stack;

public class ArrayStack {
	private static final int DEFAULT_CAPACITY = 10;
	private int[] data;
	private int top = -1;

	public ArrayStack() {
		this.data = new int[DEFAULT_CAPACITY];
	}

	public ArrayStack(int size) {
		this.data = new int[size];
	}

	public int size() {
		return top != -1 ? top + 1 : 0;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int element) throws Exception {
		if (top == DEFAULT_CAPACITY - 1) {
			throw new Exception("Stack is full!");
		}
		this.data[++this.top] = element;
	}

	public int pop() throws Exception {
		if (top == -1) {
			throw new Exception("Stack is empty!");
		}
		return this.data[this.top--];
	}

	public int get() throws Exception {
		if (this.top == -1) {
			throw new Exception("Stack is empty!");
		}
		return this.data[this.top];
	}
}
