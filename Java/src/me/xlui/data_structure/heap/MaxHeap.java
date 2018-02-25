package me.xlui.data_structure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 堆（heap），这里说的堆是数据结构中的堆，而不是内存模型中的堆。堆通常可以被看作一棵树，他满足以下性质：
 * <ul>
 * <li>堆中任意结点的值总是不大于（不小于）其子结点的值</li>
 * <li>堆总是一颗完全树</li>
 * </ul>
 * </p>
 * <p>
 * <p>将任意结点不大于其子结点的堆叫做<strong>最小堆</strong>，而将任意结点不小于其子结点的堆叫做<strong>最大堆</strong>。常见的堆有二叉堆、左倾堆、斜堆、二项堆、斐波那契堆等等。</p>
 * <p>
 * <p>二叉堆是完全二元树或者是近似完全二元树，它分为两种：最大堆或最小堆。</p>
 * <p>
 * <p>二叉堆一般都通过**数组**实现。数组实现的二叉堆，父结点和子结点的位置存在一定的关系。有时候，我们将二叉堆的第一个元素放在索引 0 的位置，有时候放在 1 的位置。当然，它们的本质一样，只是实现上稍微有一丁点的区别。</p>
 * <p>
 * <p>
 * 假设第一个元素在数组中索引为 0，则父结点和子结点的位置关系如下：
 * <ul>
 * <li>索引 i 结点的左孩子的索引是 (2i + 1)</li>
 * <li>索引 i 结点的右孩子的索引是 (2i + 2)</li>
 * <li>索引 i 结点的父结点的索引是 (i - 1) / 2 取整数</li>
 * </ul>
 * </p>
 * <p>
 * <p>
 * 假设第一个元素在数组中索引为 1，则父结点和子结点的位置关系如下：
 * <ul>
 * <li>索引 i 结点的左孩子的索引是 2i</li>
 * <li>索引 i 结点的右孩子的索引是 2i + 1</li>
 * <li>索引 i 结点的父结点的索引是 i / 2 取整数</li>
 * </ul>
 * </p>
 * <p>
 * <p>
 * 以下代码实现里统统采用<strong>二叉堆的第一个元素在数组索引为 0</strong>的方式
 * </p>
 */
@SuppressWarnings("unchecked")
public class MaxHeap<T extends Comparable<T>> implements Heap<T> {
	private List<T> heap;

	public MaxHeap() {
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
			if (this.heap.get(parent).compareTo(t) < 0) {
				// 父结点位置元素小于新插入结点元素的值
				// 交换小的元素到新插入的位置
				this.heap.set(current, this.heap.get(parent));
				// current 移动到父节点的位置继续比较
				current = parent;
				// parent 移动到现在 current 的父节点
				parent = (current - 1) / 2;
			} else {
				// 父节点位置元素大于等于新插入结点元素的值，无需移动
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
				if (left < end && this.heap.get(left).compareTo(this.heap.get(left + 1)) < 0) {
					left++; // left 指向左右孩子中较大者
				}
				if (tmp.compareTo(this.heap.get(left)) < 0) {
					// 填补的元素比左右孩子中较大者小
					// 将较大者交换到填补位置
					this.heap.set(index, this.heap.get(left));
					// index 指向较大者位置
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
