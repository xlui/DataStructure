package me.xlui.data_structure.heap;

public interface Heap<E> {
	int size();

	boolean isEmpty();

	void add(E e);

	default void remove(E e) {
	}

	default E remove() {
		return null;
	}

	E peek();

	E poll();
}
