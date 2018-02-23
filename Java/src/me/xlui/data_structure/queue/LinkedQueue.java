package me.xlui.data_structure.queue;

/**
 * 队列 —— 链表实现
 */
@SuppressWarnings("unchecked")
public class LinkedQueue<E> implements Queue<E> {
	private Node queue = null;
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public void add(E e) {
		if (this.isEmpty()) {
			this.queue = new Node(e);
			this.head = this.queue;
			this.tail = this.queue;
			this.size++;
			return;
		}
		Node node = new Node(e);
		this.tail.next = node;
		this.tail = node;
		this.size++;
	}

	@Override
	public E peek() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Linked queue is empty!");
		}
		return (E) this.head.data;
	}

	@Override
	public E poll() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Linked queue is empty!");
		}
		E e = (E) this.head.data;
		this.head = this.head.next;
		this.size--;
		return e;
	}

	private static final class Node<E> {
		E data;
		Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
