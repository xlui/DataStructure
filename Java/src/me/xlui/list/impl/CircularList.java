package me.xlui.list.impl;

/**
 * 循环链表
 */
public class CircularList {
	private Node head;
	private int size;

	public CircularList() {
		this.head = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void insert(int element) {
		// 处理 head 为 null 的情况
		if (this.head == null) {
			this.head = new Node(element);
			this.head.next = this.head;
			++this.size;
			return;
		}

		Node tmp = this.head;
		Node node = new Node(element);
		while (tmp.next != this.head) {
			// 转到循环链表尾
			tmp = tmp.next;
		}
		tmp.next = node;
		node.next = this.head;
		++this.size;
	}

	public void insert(int index, int element) throws Exception {
		if (this.head == null) {
			throw new Exception("Circular list is empty!");
		}

		Node tmp = this.head;
		Node node = new Node(element);

		if (index % size == 0) {
			// 如果插入的 index 是 循环链表头
			while (tmp.next != this.head)
				tmp = tmp.next;
			node.next = this.head;
			tmp.next = node;
			this.head = node;
			++this.size;
			return;
		}

		// 遍历到插入的位置前一个结点
		for (int i = 1; i < index; i++) {
			tmp = tmp.next;
		}
		node.next = tmp.next;
		tmp.next = node;
		++this.size;
	}

	public boolean remove(int element) throws Exception {
		if (this.head == null) {
			throw new Exception("Circular list is empty!");
		}

		Node tmp = this.head;
		if (this.head.data == element) {
			// 如果要删除头结点
			while (tmp.next != this.head)
				tmp = tmp.next;
			this.head = this.head.next;
			tmp.next = this.head;
			--this.size;
			return true;
		}

		while (tmp.next.data != element && tmp.next != this.head) {
			// 转移到要删除的结点的前一个结点
			tmp = tmp.next;
		}
		if (tmp.next.data == element) {
			// 排除结点不存在的情况
			tmp.next = tmp.next.next;
			--this.size;
			return true;
		}

		return false;
	}

	public void access() throws Exception {
		if (this.head == null) {
			throw new Exception("Circular list is empty!");
		}

		Node tmp = this.head;

		do {
			System.out.println(tmp.data + " ");
			tmp = tmp.next;
		} while (tmp != this.head);

		System.out.println();
	}

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
