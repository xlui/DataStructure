package me.xlui.data_structure.list.impl;

public interface List<E> {
	int size();

	boolean isEmpty();

	boolean add(E e);

	boolean remove(E e);

	void access();
}
