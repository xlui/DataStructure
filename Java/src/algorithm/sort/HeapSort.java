package algorithm.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆排序
 *
 * <blockquote>是对选择排序的改进，缩小查找最小元素的时间</blockquote>
 *
 * 分析：
 *
 * 时间复杂度为 O(N logN)
 */
public class HeapSort {
	public static void sort(int[] numbers) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.comparing(Integer::intValue));

		for (int number : numbers) {
			heap.add(number);
		}

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = heap.poll();
		}
	}
}
