package algorithm.sort;

/**
 * 冒泡排序
 *
 * 特点：每一趟排序完成后，最大的数一定在最后面。
 * 特定：冒泡排序是一个稳定的排序算法。
 */
public class BubbleSort {
	public static void sort(int[] numbers) {
		// 从后往前开始遍历，每次外层循环结束，i 位置（当前最后）的元素为 0 - i 中最大的元素
		for (int i = numbers.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[i]) {
					int tmp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = tmp;
				}
			}
		}
	}

	/**
	 * 优化策略：如果一趟排序中没有发生任何数据交换，说明数据已经是有序的了，直接终止循环。
	 */
	public static void optimize_sort(int[] numbers) {
		boolean flag;
		for (int i = numbers.length - 1; i > 0; i--) {
			flag = true;

			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[i]) {
					int tmp = numbers[j];
					numbers[j] = numbers[i];
					numbers[i] = tmp;
					flag = false;
				}
			}

			if (flag) {
				break;
			}
		}
	}
}
