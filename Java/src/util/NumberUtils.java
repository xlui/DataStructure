package util;

import java.util.Random;

public class NumberUtils {
	public static int[] generate(int count, int range) {
		Random random = new Random();
		int[] res = new int[count];
		for (int i = 0; i < count; i++) {
			res[i] = 1 + random.nextInt(range);
		}
		return res;
	}

	public static void print(int[] numbers) {
		for (int number : numbers) {
			System.out.print(number + " ");
		}
		System.out.println();
	}

	public static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}

	public static void main(String[] args) {
		int[] numbers = NumberUtils.generate(10, 100);
		NumberUtils.print(numbers);
	}
}
