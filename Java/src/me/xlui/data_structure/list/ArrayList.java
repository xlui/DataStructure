package me.xlui.data_structure.list;

/**
 * 数组实现的顺序表
 */
@SuppressWarnings("unchecked")
public class ArrayList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private Object[] data;

	public ArrayList() {
		this.data = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public ArrayList(int size) {
		this.data = new Object[size];
		this.size = 0;
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
		if (this.size + 1 > DEFAULT_CAPACITY) {
			return false;
		}
		this.data[this.size++] = e;
		return true;
	}

	@Override
	public boolean add(int index, E e) {
		if (this.size + 1 > DEFAULT_CAPACITY) {
			return false;
		}
		// System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
		this.data[index] = e;
		++this.size;
		return true;
	}

	@Override
	public boolean remove(E e) {
		int index = this.indexOf(e);
		if (index == -1) {
			return false;
		}
		System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
		return true;
	}

	@Override
	public E get(int index) {
		return (E) this.data[index];
	}

	@Override
	public void access() {
		for (Object datum : data) {
			System.out.print(datum + " ");
		}
		System.out.println();
	}

	/**
	 * 计算 ArrayList 中 var 的 index，如果没有 var 就返回 -1
	 * 时间复杂度 O(N)
	 */
	public int indexOf(E var) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i].equals(var)) {
				return i;
			}
		}
		return -1;
	}
}
