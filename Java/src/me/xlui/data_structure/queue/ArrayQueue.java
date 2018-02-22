package me.xlui.data_structure.queue;

/**
 * 队列 —— 数组实现
 */
@SuppressWarnings("unchecked")
public class ArrayQueue<E> implements Queue<E> {
	private static final int DEFAULT_CAPACITY = 20;
	private Object[] data;
	private int size = 0;
	private int head = 0;
	private int tail = 0;

	public ArrayQueue() {
		this.data = new Object[DEFAULT_CAPACITY];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void add(E e) throws Exception {
		if (this.tail >= DEFAULT_CAPACITY) {
			throw new Exception("Queue is full!");
		}
		this.data[this.tail++] = e;
		this.size++;
	}

	@Override
	public E peek() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Queue is empty!");
		}
		return (E) this.data[this.head];
	}

	@Override
	public E poll() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Queue is empty!");
		}
		this.size--;
		return (E) this.data[this.head--];
	}
}
