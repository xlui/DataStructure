package me.xlui.list;

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

	public int indexOf(int var) {
		for (int i = 0; i < this.size; i++) {
			if (this.data[i] == var) {
				return i;
			}
		}
		return -1;
	}

	public boolean insert(int position, int var) throws Exception {
		if (this.size + 1 > DEFAULT_CAPACITY) {
			throw new Exception("No enough space!");
		}
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
