package algorithm.max_subsequence_sum;

public class Main {
	public static void main(String[] args) {
		int[] sequence = new int[]{4, -3, 5, -2, -1, 2, 6, -2};
		System.out.println(Algorithm1.maxSubSequenceSum(sequence));
		System.out.println(Algorithm2.maxSubSequenceSum(sequence));
		System.out.println(Algorithm3.maxSubSequenceSum(sequence, 0, sequence.length - 1));
		System.out.println(Algorithm4.maxSubSequenceSum(sequence));
	}
}
