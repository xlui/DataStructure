package data_structure.queue;

public interface Queue<E> {
	int size();

	boolean isEmpty();

	void add(E e) throws Exception;

	E peek() throws Exception;

	E poll() throws Exception;
}
