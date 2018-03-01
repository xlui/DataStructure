package me.xlui.algorithm.sort;

import java.util.Arrays;

public class BucketSort {
	private static final int MAX = 100;

	public static void sort(int[] numbers) {
		int[] buckets = new int[MAX];
		Arrays.fill(buckets, 0);

		// 计数
		for (int i = 0, len = numbers.length; i < len; i++) {
			buckets[numbers[i]]++;
		}

		// 排序
		for (int i = 0, j = 0; i < MAX; i++) {
			while ((buckets[i]--) > 0) {
				numbers[j++] = i;
			}
		}
	}
}
