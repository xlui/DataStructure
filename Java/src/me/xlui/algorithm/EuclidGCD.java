package me.xlui.algorithm;

public class EuclidGCD {
	public static void main(String[] args) {
		System.out.println(euclid(1989, 1590));	// 3
	}

	public static int euclid(int number1, int number2) {
		int remainder;

		while (number2 > 0) {
			remainder = number1 % number2;
			number1 = number2;
			number2 = remainder;
		}

		return number1;
	}
}
