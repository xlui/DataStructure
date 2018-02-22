package me.xlui.question;

import java.util.Stack;

public class SuffixToResult {
	public static int compute(String suffix) {
		String[] strings = suffix.split(" ");
		Stack<Integer> stack = new Stack<>();
		for (String string : strings) {
			if (string.matches("\\d+")) {
				stack.push(Integer.valueOf(string));
			} else {
				if (stack.isEmpty()) {
					return -1;
				}

				int num1 = stack.pop();
				int num2 = stack.pop();
				int result = 0;
				switch (string) {
					// 其中 num2 和 num1 的顺序不能乱。因为中缀表达式转后缀表达式的时候，左操作数（操作符左侧）
					// 先入栈，右操作数后入栈。所以 pop 的时候右操作数先出栈，左操作数后出栈
					case "+":
						result = num2 + num1;
						break;
					case "-":
						result = num2 - num1;
						break;
					case "*":
						result = num2 * num1;
						break;
					case "/":
						result = num2 / num1;
						break;
				}
				stack.push(result);
			}
		}

		if (stack.size() == 1) {
			return stack.pop();
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		String expression = "9 3 1 - 3 * + 10 2 / + ";
		System.out.println(SuffixToResult.compute(expression));
	}
}
