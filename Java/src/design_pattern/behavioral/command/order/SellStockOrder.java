package design_pattern.behavioral.command.order;

import design_pattern.behavioral.command.Stock;

public class SellStockOrder implements Order {
	private Stock absStock;

	@Override
	public void execute() {
		absStock.sell();
	}

	public SellStockOrder(Stock absStock) {
		this.absStock = absStock;
	}
}
