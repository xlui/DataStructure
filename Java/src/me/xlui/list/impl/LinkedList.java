package me.xlui.list.impl;

public class LinkedList {
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

	public void add(int element) {
		if (this.head == null) {
			this.head = new Node(element);
			this.size++;
			return;
		}
		Node tmp = this.head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = new Node(element);
		++this.size;
	}

	public void add(int index, int element) {
		if (index > size) {
			throw new IllegalArgumentException("Invalid index!");
		}

		Node tmp = this.head;
		Node newNode = new Node(element);

		if (index == 0) {
			newNode.next = this.head;
			this.head = newNode;
			++this.size;
			return;
		}

		for (int i = 1; i < index; i++) {
			tmp = tmp.next;
		}
		newNode.next = tmp.next;
		tmp.next = newNode;
		this.size++;
	}

	public void remove(int element) {
		if (this.head == null) {
			this.head = null;
			--this.size;
			return;
		}
		if (this.head.data == element) {
			this.head = this.head.next;
			--this.size;
			return;
		}

		Node node = this.head;
		while (node.next != null && node.next.data != element) {
			node = node.next;
		}
		if (node.next != null) {
			node.next = node.next.next;
		}
		--this.size;
	}

	public void access() {
		Node tmp = this.head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	private static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
