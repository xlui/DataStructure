package design_pattern.behavioral.strategy;

import design_pattern.behavioral.strategy.strategy.Strategy;

public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int n1, int n2) {
		return strategy.doOperation(n1, n2);
	}
}
