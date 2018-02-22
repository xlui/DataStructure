package me.xlui.question;

import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 * <p>
 * 中缀表达式： a + b * c + (d * e + f) * g 转换为
 * 后缀表达式： a b c * + d e * f + g * +
 * <p>
 * 转换的逻辑：
 * 1、遇到操作数，直接输出
 * 3、遇到 左括号，进栈
 * 3、遇到 右括号，将栈中元素弹出，直到遇到左括号为止。左括号不输出
 * 4、遇到其他操作符，从栈中弹出元素直到遇到更低优先级的元素（或栈为空），然后将操作符入栈
 * 5、左括号 直到遇到 右括号 的时候才弹出，遇到普通操作符不弹出
 * 6、读到输入的末尾，将栈中剩余的元素依次弹出
 */
public class InfixToSuffix {
	/**
	 * 入栈判断。
	 * 1、栈顶是左括号，直接入栈
	 * 2、输入是乘除，栈顶是加减，入栈
	 * 3、其他情况，栈顶元素出栈
	 */
	private static boolean compare(String input, String top) {
		return "(".equals(top) || ("*".equals(input) || "/".equals(input)) && ("+".equals(top) || "-".equals(top));
	}

	public static void convert(String input) {
		String[] strings = input.split(" ");
		Stack<String> stack = new Stack<>();

		for (String string : strings) {
			if ("(".equals(string)) {
				// 遇到左括号，直接入栈
				stack.push(string);
			} else if (")".equals(string)) {
				// 遇到右括号，弹出元素直到弹出对应的左括号
				String top;
				while (!stack.isEmpty()) {
					top = stack.pop();
					if (top.equals("("))
						// 弹出了左括号，停止循环
						break;
					else
						System.out.print(top + " ");
				}
			} else if ("+-*/".contains(string)) {
				// 普通操作符
				if (stack.isEmpty()) {
					// 栈为空时直接入栈
					stack.push(string);
				} else {
					String top = stack.peek();
					if (compare(string, top)) {
						// 判断栈顶元素优先级比操作符低，直接入栈
						stack.push(string);
					} else {
						// 栈顶元素优先级比操作符高，依次弹出
						while (!stack.isEmpty()) {
							top = stack.peek();
							if (!compare(string, top)) {
								// 先取栈顶元素进行比较，再弹出的原因是避免 左括号（ 被误弹出
								System.out.print(stack.pop() + " ");
							} else {
								break;
							}
						}
						// 现在栈顶元素的优先级比操作符低，操作符入栈
						stack.push(string);
					}
				}
			} else {
				// 数字，直接输出
				System.out.print(string + " ");
			}
		}

		// 输出栈中剩余元素
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public static void main(String[] args) {
		String expression = "9 + ( 3 - 1 ) * 3 + 10 / 2";
		InfixToSuffix.convert(expression);
	}
}
