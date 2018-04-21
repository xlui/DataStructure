package data_structure.list;

/**
 * 双向链表
 */
@SuppressWarnings("unchecked")
public class DoubleLinkedList<E> implements List<E> {
	private int size = 0;
	private Node list;

	public DoubleLinkedList() {
		this.list = null;
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
		if (this.isEmpty()) {
			this.list = new Node<>(e);
			this.size++;
			return true;
		}
		Node node = this.list;
		Node newNode = new Node<>(e);
		while (node.next != null) {
			node = node.next;
		}
		node.next = newNode;
		newNode.previous = node;
		this.size++;
		return true;
	}

	@Override
	public boolean add(int index, E e) {
		if (index > this.size) {
			throw new IllegalArgumentException("Invalid index!");
		}

		Node newNode = new Node<>(e);

		if (index == 0) {
			newNode.next = this.list;
			this.list.previous = newNode;
			this.list = newNode;
			this.size++;
			return true;
		}

		Node node = this.list;
		for (int i = 1; i < index; i++) {
			node = node.next;
		}
		newNode.next = node.next;
		node.next = newNode;
		newNode.previous = node;
		if (newNode.next != null)
			newNode.next.previous = newNode;
		this.size++;
		return true;
	}

	@Override
	public boolean remove(E e) {
		Node node = this.list;

		while (node != null && !node.data.equals(e)) {
			node = node.next;
		}
		if (node == null) {
			return true;
		}

		if (node.previous != null) {
			node.previous.next = node.next;
			if (node.next != null)
				node.next.previous = node.previous;
		} else {
			this.list = node.next;
			this.list.previous = null;
		}
		return true;
	}

	@Override
	public E get(int index) {
		if (index >= this.size) {
			throw new IllegalArgumentException("Invalid index!");
		}

		Node node = this.list;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return (E) node.data;
	}

	@Override
	public void access() {
		Node node = this.list;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	private static class Node<E> {
		E data;
		Node previous;
		Node next;

		public Node(E data) {
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}
}
