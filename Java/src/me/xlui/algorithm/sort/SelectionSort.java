package me.xlui.algorithm.sort;

/**
 * 选择排序
 *
 * <blockquote>每次从序列中选择最小（最大）的元素，放到序列起始位置（末尾）</blockquote>
 */
public class SelectionSort {
	public static void sort(int[] numbers) {
		int min;
		for (int i = 0, len = numbers.length; i < len; i++) {
			min = i;
			for (int j = i + 1; j < len; j++) {
				// 获取未排序元素中的最小值
				if (numbers[j] < numbers[min])
					min = j;
			}
			// 若 min != i，则交换 numbers[i] 和 numbers[min]
			if (min != i) {
				int tmp = numbers[i];
				numbers[i] = numbers[min];
				numbers[min] = tmp;
			}
		}
	}
}
