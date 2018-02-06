package me.xlui.algorithm;

public class BinarySearch {
	public static void main(String[] args) {
		int[] sequence = new int[]{1, 3, 4, 5, 6, 7, 9, 14, 17};
		System.out.println(binarySearch(sequence, 4));
	}

	public static int binarySearch(int[] sequence, int n) {
		// 二分查找，在一个有序序列中高效查找数据的算法
		int low = 0, high = sequence.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			System.out.println("Try " + sequence[mid]);
			if (n < sequence[mid]) {
				high = mid;
			} else if (n > sequence[mid]) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
