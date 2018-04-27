package algorithm.sort;

/**
 * 快速排序
 *
 * 有几点需要注意的：
 *
 * 1、主元（pivot）的选择
 * 2、将序列通过主元划分为两个子集不能耗费太长时间
 *
 * 选主元的策略：
 *
 * 1、取头、中、尾的中位数。例如 8、12、3 的中位数是 8
 * 2、取 5 个数的中位数
 *
 * 特点：
 *
 * 快速排序的主元在子集划分完成后直接放入了正确的位置
 */
public class QuickSort {
	public static void sort(int[] numbers) {
		sort(numbers, 0, numbers.length - 1);
	}

	private static void sort(int[] numbers, int left, int right) {
		if (left < right) {
			int i = left, j = right;
			int pivot = numbers[i];
			while (i < j) {
				// 从右向左找第一个小于 pivot 的数
				while (i < j && numbers[j] > pivot)
					j--;
				// 交换到 left 的位置
				if (i < j)
					numbers[i] = numbers[j];
				// 从左往右找第一个大于 pivot 的数
				while (i < j && numbers[i] < pivot)
					i++;
				// 交换到 j 的位置
				if (i < j)
					numbers[j] = numbers[i];
			}
			numbers[i] = pivot;
			sort(numbers, left, i - 1);
			sort(numbers, i + 1, right);
		}
	}

//	// 获取头、中、尾的中位数
//	private static int pivot(int[] numbers, int start, int end) {
//		int n1 = numbers[start], n2 = numbers[start / 2 + end / 2], n3 = numbers[end];
//		return n1 < n2 ? (n2 < n3 ? n2 : (n1 < n3 ? n3 : n1)) : (n2 > n3 ? n2 : (n3 > n1 ? n1 : n3));
//		List<Integer> list = new ArrayList<>(Arrays.asList(numbers[start], numbers[start / 2 + end / 2], numbers[end]));
//		list.sort(Integer::compareTo);
//		return list.get(1);
//	}
}
