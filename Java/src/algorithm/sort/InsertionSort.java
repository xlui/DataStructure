package algorithm.sort;

/**
 * 插入排序
 *
 * 特点：随着外层循环的进行，i 前的元素一定是有序的
 * 特定：是一个稳定的排序算法
 */
public class InsertionSort {
	public static void sort(int[] numbers) {
		int j;
		for (int i = 1, len = numbers.length; i < len; i++) {
			// i 位置元素是待排序元素，i 前元素是有序序列
			int tmp = numbers[i];
			for (j = i; j > 0 && numbers[j - 1] > tmp; j--) {
				// 进行比较，移动元素，空出合适的位置
				// numbers[j - 1] > tmp 说明应将 numbers[j - 1] 后移
				// 如果 numbers[j - 1] < tmp，说明应插入元素位置为 j
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = tmp;
		}
	}
}
