package me.xlui.algorithm.sort;

/**
 * 插入排序
 *
 * 特点：随着外层循环的进行，i 前的元素一定是有序的
 * 特定：是一个稳定的排序算法
 */
public class InsertionSort {
	public static void sort(int[] numbers) {
		int i, j;
		for (i = 1; i < numbers.length; i++) {
			int tmp = numbers[i];
			for (j = i; j > 0 && numbers[j - 1] > tmp; j--) {
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = tmp;
		}
	}
}
