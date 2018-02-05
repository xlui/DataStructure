package me.xlui.algorithm.max_subsequence_sum;

// 算法 1 -- 遍历所有子序列得出结果
public class Algorithm1 {
	public static int maxSubSequenceSum(int[] sequence) {
		int max = 0, this_sum = 0;

		for (int i = 0; i < sequence.length; i++) {
			for (int j = i; j < sequence.length; j++) {
				this_sum = 0;

				for (int k = i; k <= j; k++) {
					this_sum += sequence[k];
				}

				if (this_sum > max) {
					max = this_sum;
				}
			}
		}

		return max;
	}
}
