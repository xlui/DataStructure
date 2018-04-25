package design_pattern.strategy.strategy;

public class MulStrategy implements Strategy {
	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}
