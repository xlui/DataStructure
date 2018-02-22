package me.xlui.algorithm.sort;

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
		if (numbers.length < 2)
			return;
		int pivot = numbers[(int) (Math.random() * 10)];
		System.out.println("Pivot：" + pivot);

	}
}
