package me.xlui.algorithm.sort;

/**
 * 选择排序
 *
 * <blockquote>每次从序列中选择最小（最大）的元素，放到序列起始位置（末尾）</blockquote>
 */
public class SelectionSort {
	public static void sort(int[] numbers) {
		int min;

		for (int i = 0; i < numbers.length; i++) {
			min = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[min])
					min = j;
			}
			if (min != i) {
				int tmp = numbers[i];
				numbers[i] = numbers[min];
				numbers[min] = tmp;
			}
		}
	}
}
