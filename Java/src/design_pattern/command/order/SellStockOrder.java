package design_pattern.command.order;

import design_pattern.command.Stock;

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
