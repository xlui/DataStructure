package me.xlui.algorithm.max_subsequence_sum;

public class Algorithm4 {
	public static int maxSubSequenceSum(int[] sequence) {
		int max = 0, this_sum = 0;

		for (int i : sequence) {
			this_sum += i;

			if (this_sum > max) {
				max = this_sum;
			} else if (this_sum < 0) {
				this_sum = 0;
			}
		}

		return max;
	}
}
