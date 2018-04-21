package algorithm;

public class EuclidGCD {
	public static void main(String[] args) {
		System.out.println(euclid(1989, 1590));	// 3
	}

	public static int euclid(int number1, int number2) {
		// 欧几里得 -- 辗转相除法，求两个数的最大公约数
		int remainder;

		while (number2 > 0) {
			remainder = number1 % number2;
			number1 = number2;
			number2 = remainder;
		}

		return number1;
	}
}
