package me.xlui.data_structure.list;

/**
 * 单向链表
 */
@SuppressWarnings("unchecked")
public class LinkedList<E> implements List<E> {
	private int size = 0;
	private Node head;

	public LinkedList() {
		this.head = null;
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
	public boolean add(E e) {
		if (this.head == null) {
			this.head = new Node<>(e);
			this.size++;
			return true;
		}
		Node tmp = this.head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = new Node<>(e);
		++this.size;
		return true;
	}

	@Override
	public boolean add(int index, E e) {
		if (index > size) {
			throw new IllegalArgumentException("Invalid index!");
		}

		Node tmp = this.head;
		Node newNode = new Node<>(e);

		if (index == 0) {
			newNode.next = this.head;
			this.head = newNode;
			++this.size;
			return true;
		}

		for (int i = 1; i < index; i++) {
			tmp = tmp.next;
		}
		newNode.next = tmp.next;
		tmp.next = newNode;
		this.size++;
		return true;
	}

	@Override
	public boolean remove(E e) {
		if (this.head == null) {
			throw new IllegalArgumentException("Linked list is empty!");
		}

		if (this.head.data.equals(e)) {
			this.head = this.head.next;
			--this.size;
			return true;
		}

		Node node = this.head;
		while (node.next != null && !node.next.data.equals(e)) {
			node = node.next;
		}
		if (node.next != null) {
			node.next = node.next.next;
			--this.size;
			return true;
		}
		return false;
	}

	@Override
	public E get(int index) {
		if (index >= size) {
			throw new IllegalArgumentException("Invalid index!");
		}

		Node node = this.head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return (E) node.data;
	}

	@Override
	public void access() {
		Node node = this.head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static class Node<E> {
		E data;
		Node next;

		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
