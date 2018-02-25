package me.xlui.data_structure.heap;

public interface Heap<E> {
	int size();

	boolean isEmpty();

	void add(E e);

	void remove(E e);

	E peek();

	E poll();
}
