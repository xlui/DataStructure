package me.xlui.data_structure.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> implements Heap<T> {
	private List<T> heap;

	public MinHeap() {
		this.heap = new ArrayList<>();
	}

	@Override
	public int size() {
		return this.heap.size();
	}

	@Override
	public boolean isEmpty() {
		return this.heap.isEmpty();
	}

	@Override
	public void add(T t) {
		this.heap.add(t);

		int current = this.heap.size() - 1;
		int parent = (current - 1) / 2;
		while (current > 0) {
			if (this.heap.get(parent).compareTo(t) > 0) {
				// 父结点位置元素大于新插入结点元素的值
				// 交换大的元素到新插入的位置
				this.heap.set(current, this.heap.get(parent));
				// current 移动到父结点的位置继续比较
				current = parent;
				// parent 移动到现在 current 的父结点
				parent = (current - 1) / 2;
			} else {
				// 父结点位置元素小于等于新插入结点元素的值，无需移动
				break;
			}
		}
		this.heap.set(current, t);
	}

	@Override
	public void remove(T t) {
		if (this.heap.isEmpty()) {
			// 堆为空，返回
			return;
		}

		int index = this.heap.indexOf(t);
		int size = this.heap.size();
		if (-1 == index) {
			// 堆中没有要删除的元素，返回
			return;
		}
		// 用最后的元素填补要删除元素的位置
		this.heap.set(index, this.heap.get(size - 1));
		// 删除最后的元素
		this.heap.remove(size - 1);

		if (this.heap.size() > 1) {
			// 进行调整
			int left = 2 * index + 1;   // 左孩子
			int end = this.heap.size() - 1;
			T tmp = this.heap.get(index);
			while (left <= end) {
				if (left < end && this.heap.get(left).compareTo(this.heap.get(left + 1)) > 0) {
					left++; // left 指向左右孩子中较小者
				}
				if (tmp.compareTo(this.heap.get(left)) > 0) {
					// 填补的元素比左右孩子中较小者大
					// 将较小者交换到填补位置
					this.heap.set(index, this.heap.get(left));
					// index 指向较小者位置
					index = left;
					// left 指向 index 的左儿子
					left = 2 * index + 1;
				} else {
					// 调整结束
					break;
				}
			}
			this.heap.set(index, tmp);
		}
	}

	@Override
	public T peek() {
		return this.heap.get(0);
	}

	@Override
	public T poll() {
		T t = this.peek();
		this.remove(t);
		return t;
	}

	public void access() {
		for (T t : heap) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
}
