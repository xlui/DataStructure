package design_pattern.behavioral.strategy.strategy;

public class SubStrategy implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}
}
