package me.xlui.data_structure.stack;

public class Main {
	public static void main(String[] args) throws Exception {
		LinkedStack stack = new LinkedStack();

		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(-9);
		stack.push(-2);
		stack.push(-3);
		stack.push(-1314);
		stack.push(-23);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
	}
}
