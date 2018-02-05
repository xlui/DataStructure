package me.xlui.algorithm.max_subsequence_sum;

public class Algorithm2 {
	public static int maxSubSequenceSum(int[] sequence) {
		int max = 0, this_sum = 0;

		for (int i = 0; i < sequence.length; i++) {
			this_sum = 0;
			// 相对一算法 1 的改进，直接计算和，没必要再再遍历一次
			for (int j = i; j < sequence.length; j++) {
				this_sum += sequence[j];

				if (this_sum > max) {
					max = this_sum;
				}
			}
		}

		return max;
	}
}
