package data_structure.list;

public interface List<E> {
	int size();

	boolean isEmpty();

	boolean add(E e);

	boolean add(int index, E e);

	boolean remove(E e);

	E get(int index);

	void access();
}
