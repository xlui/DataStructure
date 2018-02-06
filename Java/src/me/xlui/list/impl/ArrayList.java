package me.xlui.list.impl;

/**
 * 数组实现的顺序表
 */
public class ArrayList {
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	private int[] data;

	public ArrayList() {
		this.data = new int[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * 计算 ArrayList 中 var 的 index，如果没有 var 就返回 -1
	 * 时间复杂度 O(N)
	 */
	public int indexOf(int var) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i] == var) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 插入操作，当数组空间不够时抛出异常
	 */
	public boolean insert(int position, int var) throws Exception {
		if (this.size + 1 > DEFAULT_CAPACITY) {
			throw new Exception("No enough space!");
		}
		// System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
		System.arraycopy(this.data, position, this.data, position + 1, this.size - position);
		this.data[position] = var;
		++this.size;
		return true;
	}

	public boolean remove(int var) throws Exception {
		int index = this.indexOf(var);
		if (index == -1) {
			throw new Exception("No such value!");
		}
		System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
		return true;
	}
}
