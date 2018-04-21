package algorithm.sort;

/**
 * 归并算法
 *
 * <h1>概念：</h1>
 *
 * 归并：将两个有序数列合并成一个有序数列
 */
public class MergeSort {
	// 自顶向下排序
	public static void sortUp2Down(int[] numbers) {
		sortUp2Down(numbers, 0, numbers.length - 1);
	}

	// 自底向上排序
	public static void sortDown2Up(int[] numbers) {
		if (numbers == null) {
			return;
		}
		for (int i = 1, len = numbers.length; i < len; i *= 2) {
			sortDown2Up(numbers, len, i);
		}
	}

	private static void sortUp2Down(int[] numbers, int start, int end) {
		if (numbers == null || start >= end) {
			return;
		}
		int mid = start / 2 + end / 2;
		sortUp2Down(numbers, start, mid);
		sortUp2Down(numbers, mid + 1, end);

		merge(numbers, start, mid, end);
	}

	private static void sortDown2Up(int[] numbers, int len, int gap) {
		int twoLen = gap * 2;
		int i;
		// 将每两个相邻的子数组进行归并
		for (i = 0; i + twoLen - 1 < len; i += twoLen) {
			merge(numbers, i, i + gap - 1, i + twoLen - 1);
		}

		// 若 i + gap - 1 < len - 1，则剩余一个子数组没有配对
		// 将该子数组归并到已排序的数组中
		if (i + gap - 1 < len - 1) {
			merge(numbers, i, i + gap - 1, len - 1);
		}
	}

	// 合并一个数组中的两个相邻有序区间
	private static void merge(int[] numbers, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int t = 0;  // tmp 数组的索引
		int i = start;
		int j = mid + 1;

		while (i <= mid && j <= end) {
			if (numbers[i] <= numbers[j]) {
				tmp[t++] = numbers[i++];
			} else {
				tmp[t++] = numbers[j++];
			}
		}
		while (i <= mid) {
			tmp[t++] = numbers[i++];
		}
		while (j <= end) {
			tmp[t++] = numbers[j++];
		}

		System.arraycopy(tmp, 0, numbers, start, t);
	}
}
