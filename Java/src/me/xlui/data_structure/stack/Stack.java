package me.xlui.data_structure.stack;

public interface Stack<E> {
	int size();

	boolean isEmpty();

	void push(E e) throws Exception;

	E peek() throws Exception;

	E pop() throws Exception;
}
