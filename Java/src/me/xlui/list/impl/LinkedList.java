package me.xlui.list.impl;

public class LinkedList<E> implements List<E> {
	private int size = 0;
	private Node head;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

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
	public boolean remove(E e) {
		if (this.head == null) {
			this.head = null;
			--this.size;
			return true;
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
		}
		--this.size;
		return true;
	}

	public boolean add(int index, E element) {
		if (index > size) {
			throw new IllegalArgumentException("Invalid index!");
		}

		Node tmp = this.head;
		Node newNode = new Node<>(element);

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

	public void access() {
		Node tmp = this.head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
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
