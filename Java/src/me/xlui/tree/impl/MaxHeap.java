package me.xlui.tree.impl;

/**
 * 最大堆 —— 父结点的键值总是大于或者等于任何一个子结点的键值
 */
public class MaxHeap {
	private static final int DEFAULT_CAPACITY = 12;
	private static final int MAX_ELEMENT = Integer.MAX_VALUE;
	private int[] data;
	private int size;

	public MaxHeap() {
		this.data = new int[DEFAULT_CAPACITY];
		this.data[0] = MAX_ELEMENT;
		// 使用 data[0] 作为哨兵，即最大值。可以在插入的时候多一次循环，减少一个判断条件
		// 有哨兵之后，size 的值就是对应元素的下标
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == DEFAULT_CAPACITY;
	}

	public void insert(int element) throws Exception {
		if (this.isFull() || this.size + 1 == DEFAULT_CAPACITY) {
			throw new Exception("Max heap is full!");
		}

		int index = ++this.size;
		// index 指向堆的最后一个元素的位置
		for (; this.data[index / 2] < element; index /= 2) {
			// 如果插入的元素比父节点大，交换位置
			this.data[index] = this.data[index / 2];
		}
		this.data[index] = element;
	}

	public int delete() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Max heap is empty!");
		}
		int max = this.data[1], tmp = this.data[this.size--];
		int parent, child;
		// 从顶部开始慢慢过滤、重排
		for (parent = 1; parent * 2 <= this.size; parent = child) {
			child = parent * 2;
			if ((child != this.size) && this.data[child] < this.data[child + 1]) {
				// child != this.size 表明有右儿子
				// this.data[child] < this.data[child + 1] 表明右儿子比左儿子大
				// 这个判断使 child 指向儿子中较大者
				child++;
			}
			if (tmp >= this.data[child])
				// 如果 tmp 比左右儿子中较大者还大，中断循环，将 parent 处的值设为 tmp
				break;
			else
				// 否则，将较大者往上提，循环继续往下走
				this.data[parent] = this.data[child];
		}
		this.data[parent] = tmp;
		return max;
	}

	public void create(int... elements) {
		for (int element : elements) {
			this.data[this.size++] = element;
		}
//		todo: 将 data 数组转换为合适的最大堆
	}

	public void access() {
		for (int i = 1; i < this.size + 1; i++) {
			System.out.print(this.data[i] + " ");
		}
		System.out.println();
	}
}
