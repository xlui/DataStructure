package me.xlui.tree.impl;

/**
 * 最大堆 —— 父结点的键值总是大于或者等于任何一个子结点的键值
 */
public class MinHeap {
	private static final int MIN_VALUE = Integer.MIN_VALUE;
	private int[] data;
	private int size;
	private int capacity = 12;

	public MinHeap() {
		this.data = new int[capacity];
		this.data[0] = MIN_VALUE;
		// 使用 data[0] 作为哨兵，即最大值。可以在插入的时候多一次循环，减少一个判断条件
		// 有哨兵之后，size 的值就是对应元素的下标
		this.size = 0;
	}

	public MinHeap(int capacity) {
		this.data = new int[capacity];
		this.data[0] = MIN_VALUE;
		// 使用 data[0] 作为哨兵，即最大值。可以在插入的时候多一次循环，减少一个判断条件
		// 有哨兵之后，size 的值就是对应元素的下标
		this.size = 0;
	}

	public MinHeap(int... elements) throws Exception {
		this(elements.length + 1);
		for (int element : elements) {
			this.insert(element);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == capacity;
	}

	public void insert(int element) throws Exception {
		if (this.isFull() || this.size + 1 == capacity) {
			throw new Exception("Min heap is full!");
		}

		int index = ++this.size;
		// index 指向堆的最后一个元素的位置
		for (; this.data[index / 2] > element; index /= 2) {
			// 如果插入的元素比父节点大，交换位置
			this.data[index] = this.data[index / 2];
		}
		this.data[index] = element;
	}

	public int delete() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Min heap is empty!");
		}
		int max = this.data[1], tmp = this.data[this.size--];
		int parent, child;
		// 从顶部开始慢慢过滤、重排
		for (parent = 1; parent * 2 <= this.size; parent = child) {
			child = parent * 2;
			if ((child != this.size) && this.data[child] > this.data[child + 1]) {
				// child != this.size 表明有右儿子
				// this.data[child] > this.data[child + 1] 表明左儿子比右儿子大
				// 这个判断使 child 指向儿子中较小者
				child++;
			}
			if (tmp <= this.data[child])
				// 如果 tmp 比左右儿子中较小者还小，中断循环，将 parent 处的值设为 tmp
				break;
			else
				// 否则，将较小者往上提，循环继续往下走
				this.data[parent] = this.data[child];
		}
		this.data[parent] = tmp;
		return max;
	}

	public void create(int... elements) {
		for (int element : elements) {
			this.data[this.size++] = element;
		}
//		todo: 将 data 数组转化为合适的最小堆
	}

	public void access() {
		for (int i = 1; i < this.size + 1; i++) {
			System.out.print(this.data[i] + " ");
		}
		System.out.println();
	}
}
