package algorithm.max_subsequence_sum;

// 分治算法，将序列分为左右两个子序列，分别计算 左、右、中间 的子序列和，比较最大的并返回。
public class Algorithm3 {
	public static int maxSubSequenceSum(int[] sequence, int left, int right) {
		int center;
		int maxLeftSum, maxRightSum;
		int leftBorderSum, rightBorderSum;
		int maxLeftBorderSum, maxRightBorderSum;

		if (left == right) {
			if (sequence[left] > 0) {
				return sequence[left];
			} else {
				return 0;
			}
		}

		center = left / 2 + right / 2;
		// 计算左侧的最大子序列和
		maxLeftSum = maxSubSequenceSum(sequence, left, center);
		// 计算右侧的最大子序列和
		maxRightSum = maxSubSequenceSum(sequence, center + 1, right);

		// 计算包括中间的最大子序列和
		leftBorderSum = 0;
		maxLeftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += sequence[i];

			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum  = leftBorderSum;
			}
		}

		rightBorderSum = 0;
		maxRightBorderSum = 0;
		for (int i = center + 1; i < right; i++) {
			rightBorderSum += sequence[i];

			if (rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}

		return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
	}
}
