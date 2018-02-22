package me.xlui.data_structure.list;

/**
 * 循环链表
 */
@SuppressWarnings("unchecked")
public class CircularList<E> implements List<E> {
	private Node head = null;
	private int size = 0;

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
		// 处理 head 为 null 的情况
		if (this.isEmpty()) {
			this.head = new Node<>(e);
			this.head.next = this.head;
			this.size++;
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
		this.size++;
		return true;
	}

	@Override
	public boolean add(int index, E e) {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("Circular list is empty!");
		}

		Node tmp = this.head;
		Node node = new Node<>(e);

		if (index % size == 0) {
			// 如果插入的 index 是 循环链表头
			while (tmp.next != this.head)
				tmp = tmp.next;
			tmp.next = node;
			node.next = this.head;
			this.head = node;
			this.size++;
			return true;
		}

		// 遍历到插入的位置前一个结点
		for (int i = 1; i < index % size; i++) {
			tmp = tmp.next;
		}
		node.next = tmp.next;
		tmp.next = node;
		this.size++;
		return true;
	}

	@Override
	public boolean remove(E e) {
		if (this.isEmpty()) {
			throw new IllegalArgumentException("Circular list is empty!");
		}

		Node node = this.head;
		if (this.head.data.equals(e)) {
			// 如果要删除头结点
			if (this.size == 1) {
				this.head = null;
				return true;
			}
			while (node.next != this.head)
				node = node.next;
			this.head = this.head.next;
			node.next = this.head;
			this.size--;
			return true;
		}

		while (!node.next.data.equals(e) && node.next != this.head) {
			// 转移到要删除的结点的前一个结点
			node = node.next;
		}
		if (node.next.data.equals(e)) {
			// 排除结点不存在的情况
			node.next = node.next.next;
			this.size--;
			return true;
		}

		return false;
	}

	@Override
	public E get(int index) {
		Node node = this.head;
		for (int i = 0; i < index % size; i++) {
			node = node.next;
		}
		return (E) node.data;
	}

	/**
	 * 快慢指针判断链表中是否有环
	 */
	public boolean hasCircle() {
		Node fast = this.head;
		Node slow = this.head;

		while (true) {
			if (fast == null || fast.next == null) {
				// 如果快慢指针中有一个为空，则说明链表中没有环
				return false;
			} else {
				slow = slow.next;
				fast = fast.next.next;
			}

			if (fast == slow || fast.next == slow) {
				// 如果快慢指针相遇 或者 快指针跑到慢指针后边，说明有环
				return true;
			}
		}
	}

	@Override
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
		E data;
		Node next;

		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
}
