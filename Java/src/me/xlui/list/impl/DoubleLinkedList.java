package me.xlui.list.impl;

public class DoubleLinkedList {
	private int size = 0;
	private Node list;

	public DoubleLinkedList() {
		this.list = null;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void add(int element) {
		if (this.list == null) {
			this.list = new Node(element);
			++this.size;
			return;
		}
		Node node = this.list;
		Node newNode = new Node(element);
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
		newNode.previous = node;
		++this.size;
	}

	public void add(int index, int element) {
		Node newNode = new Node(element);

		if (index > this.size) {
			throw new IllegalArgumentException("Invalid index!");
		}

		if (index == 0) {
			newNode.next = this.list;
			this.list.previous = newNode;
			this.list = newNode;
			++this.size;
			return;
		}

		Node node = this.list;
		for (int i = 1; i < index; i++) {
			node = node.next;
		}
		newNode.next = node.next;
		node.next = newNode;
		newNode.previous = node;
		++this.size;
	}

	public boolean remove(int element) {
		Node node = this.list;

		while (node != null && node.data != element) {
			node = node.next;
		}
		if (node == null) {
			return true;
		}

		if (node.previous != null) {
			node.previous.next = node.next;
		} else {
			this.list = node.next;
			node.previous = null;
		}
		if (node.next != null) {
			node.next.previous = node.previous;
		}
		return true;
	}

	public void access() {
		Node node = this.list;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static class Node {
		private int data;
		private Node previous;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}
}
