package me.xlui.list.impl;

/**
 * 循环链表
 */
public class CircularList<E> implements List<E> {
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

	@Override
	public boolean add(E e) {
		// 处理 head 为 null 的情况
		if (this.head == null) {
			this.head = new Node<>(e);
			this.head.next = this.head;
			++this.size;
			return true;
		}

		Node tmp = this.head;
		Node node = new Node<>(e);
		while (tmp.next != this.head) {
			// 转到循环链表尾
			tmp = tmp.next;
		}
		tmp.next = node;
		node.next = this.head;
		++this.size;
		return true;
	}

	@Override
	public boolean remove(E e) {
		if (this.head == null) {
			return false;
		}

		Node tmp = this.head;
		if (this.head.data.equals(e)) {
			// 如果要删除头结点
			while (tmp.next != this.head)
				tmp = tmp.next;
			this.head = this.head.next;
			tmp.next = this.head;
			--this.size;
			return true;
		}

		while (!tmp.next.data.equals(e) && tmp.next != this.head) {
			// 转移到要删除的结点的前一个结点
			tmp = tmp.next;
		}
		if (tmp.next.data.equals(e)) {
			// 排除结点不存在的情况
			tmp.next = tmp.next.next;
			--this.size;
			return true;
		}

		return false;
	}

	public boolean insert(int index, E element) throws Exception {
		if (this.head == null) {
			throw new Exception("Circular list is empty!");
		}

		Node tmp = this.head;
		Node node = new Node<>(element);

		if (index % size == 0) {
			// 如果插入的 index 是 循环链表头
			while (tmp.next != this.head)
				tmp = tmp.next;
			node.next = this.head;
			tmp.next = node;
			this.head = node;
			++this.size;
			return true;
		}

		// 遍历到插入的位置前一个结点
		for (int i = 1; i < index; i++) {
			tmp = tmp.next;
		}
		node.next = tmp.next;
		tmp.next = node;
		++this.size;
		return true;
	}

	/**
	 * 快慢指针判断链表中是否有环
	 */
	public boolean hasCircle() {
		Node fast = this.head;
		Node slow = this.head;

		while (true) {
			if (fast == null || fast.next == null) {
				return false;
			} else {
				fast = fast.next.next;
				slow = slow.next;
			}

			if (fast == slow || fast.next == slow) {
				// 如果快慢指针相遇或者快指针跑到慢指针后边，说明有环
				return true;
			}
		}
	}

	public void access() {
		if (this.head != null) {
			Node tmp = this.head;
			do {
				System.out.println(tmp.data + " ");
				tmp = tmp.next;
			} while (tmp != this.head);
			System.out.println();
		}
	}

	private static class Node<E> {
		private E data;
		private Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
