package me.xlui.data_structure.list.impl;

/**
 * 数组实现的顺序表
 */
public class ArrayList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private Object[] data;

	public ArrayList() {
		this.data = new Object[DEFAULT_CAPACITY];
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
		if (this.size + 1 > DEFAULT_CAPACITY) {
			return false;
		}
		this.data[this.size++] = e;
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

	/**
	 * 插入操作，当数组空间不够时抛出异常
	 */
	public boolean insert(int position, E var) {
		if (this.size + 1 > DEFAULT_CAPACITY) {
			return false;
		}
		// System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		System.arraycopy(this.data, position, this.data, position + 1, this.size - position);
		this.data[position] = var;
		++this.size;
		return true;
	}
}
