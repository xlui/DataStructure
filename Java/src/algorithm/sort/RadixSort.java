package algorithm.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 基数排序
 */
public class RadixSort {
	public static void sort(int[] numbers) {
		int max = max(numbers);
		// 使用队列来作为桶数组中的桶，桶数组的大小为 10，因为有十个数字
		List<Queue<Integer>> buckets = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			// 初始化队列
			buckets.add(new ArrayDeque<>());
		}

		for (int exp = 1; max / exp > 0; exp *= 10) {
			for (int number : numbers) {
				// 获得 number 的最低位，存入队列
				int mod = (number / exp) % 10;
				buckets.get(mod).add(number);
			}
			int j = 0;
			// 从队列中取出元素到 numbers 数组
			for (Queue<Integer> bucket : buckets) {
				while (!bucket.isEmpty()) {
					numbers[j++] = bucket.poll();
				}
			}
		}
	}

	private static int max(int[] numbers) {
		int max = numbers[0];
		for (int number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		return max;
	}
}
