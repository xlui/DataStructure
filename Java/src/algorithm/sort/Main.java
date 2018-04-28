package algorithm.sort;

import util.NumberUtils;

import java.util.Arrays;

/**
 * <h1>一些概念：</h1>
 *
 * 稳定性：任意两个相等的数据，排序前后的相对位置不发生改变
 * 逆序对：对于下标 i < j, 如果 numbers[i] > numbers[j]，则称 (i, j) 是一对逆序对（inversion）
 * 定理：任意 N 个不同元素组成的序列平均具有 N(N - 1)/4 个逆序对
 * 定理：任何仅以交换相邻两元素来排序的算法，其平均时间复杂度为 Ω(N²)
 *
 * <h1>排序算法相关：</h1>
 *
 * 冒泡排序与插入排序都是<strong>交换两个相邻的元素，正好消去了一个逆序对</strong>
 *
 * <h1>特殊情况：</h1>
 *
 * 如果序列中逆序对很少，即序列基本有序，则插入排序简单且高效
 */
public class Main {
	public static void main(String[] args) {
		int[] numbers = NumberUtils.generate();

//		System.out.println("Before sort: ");
//		NumberUtils.print(numbers);

		// sort
//		SelectionSort.sort(numbers);
//		BubbleSort.sort(numbers);
//		InsertionSort.sort(numbers);
//		ShellSort.sort(numbers);
//		HeapSort.sort(numbers);
//		MergeSort.sortUp2Down(numbers);
//		MergeSort.sortDown2Up(numbers);
//		QuickSort.sort(numbers);
//		BucketSort.sort(numbers);
//		RadixSort.sort(numbers);
		int[] input = {100, 3, 2, 1};
		System.out.println("Before:\n" + Arrays.toString(input));
		QuickSort.sort(input);
		System.out.println("After:\n" + Arrays.toString(input));

//		System.out.println("After sort: ");
//		NumberUtils.print(numbers);
	}
}
