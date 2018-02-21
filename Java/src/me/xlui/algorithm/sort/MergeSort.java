package me.xlui.algorithm.sort;

/**
 * 归并算法
 *
 * <h1>概念：</h1>
 *
 * 归并：将两个有序数列合并成一个有序数列
 */
public class MergeSort {
	public static void sort(int[] numbers) {

	}

	private static void merge(int[] numbers, int lStart, int rStart, int rEnd) {
		int lEnd = rStart - 1;
		int index = lStart;
		int count = rEnd - lStart + 1;
		int[] tmp = new int[numbers.length];

		while (lStart <= lEnd && rStart <= rEnd) {
			if (numbers[lStart] <= numbers[rStart])
				tmp[index++] = numbers[lStart++];
			else
				tmp[index++] = numbers[rStart++];
		}
		while (lStart <= lEnd)
			tmp[index++] = numbers[lStart++];
		while (rStart <= rEnd)
			tmp[index++] = numbers[rStart++];

		for (int i = 0; i < count; i++, rEnd--) {
			numbers[rEnd] = tmp[rEnd];
		}
	}
}
