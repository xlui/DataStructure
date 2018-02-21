package me.xlui.algorithm.sort;

/**
 * 希尔排序
 *
 * <blockquote>是对插入排序算法的改进，又称为缩小增量排序</blockquote>
 *
 * 思路是：通过缩小增量排序，消除序列中的逆序对
 *
 * 过程：
 *
 * 1、定义增量序列 Dm > Dm-1 > ... > D1(1)
 * 2、对每个 Dk 进行 “Dk——间隔” 插入排序（k=m,m-1,...,1）
 *
 * 分析：
 *
 * 最坏情况：Θ(N²)
 *
 * 性质：
 *
 * <strong>“Dk——间隔” 有序的序列，在执行 “Dk-1——间隔” 排序后，仍然是 “Dk-间隔” 有序的</strong>
 *
 * 问题：
 *
 * <strong>如果增量元素不互质，则小增量可能之后的排序中不起作用</strong>
 *
 * 解决增量序列问题：
 *
 * 1、Hibbard 增量序列：Dk = 2^k - 1
 * 最坏情况：Θ(N^3/2)
 * 2、Sedgewick 增量序列：
 * {1, 5, 19, 41, 109}
 *      9*4^i - p*2^i + 1 或者 4^i - 3*2^i + 1
 * 最坏情况：O(N^4/3)
 */
public class ShellSort {
	public static void sort(int[] numbers) {
		int k;
		for (int i = numbers.length / 2; i > 0; i /= 2) {
			for (int j = i; j < numbers.length; j++) {
				int tmp = numbers[j];
				for (k = j; k >= i && numbers[k - i] > tmp; k -= i) {
					numbers[k] = numbers[k - i];
				}
				numbers[k] = tmp;
			}
		}
	}
}
