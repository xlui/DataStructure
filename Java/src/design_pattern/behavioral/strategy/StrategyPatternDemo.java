package design_pattern.behavioral.strategy;

import design_pattern.behavioral.strategy.strategy.AddStrategy;
import design_pattern.behavioral.strategy.strategy.MulStrategy;
import design_pattern.behavioral.strategy.strategy.SubStrategy;

public class StrategyPatternDemo {
	public static void main(String[] args) {
		Context context = new Context(new AddStrategy());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new SubStrategy());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new MulStrategy());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}
