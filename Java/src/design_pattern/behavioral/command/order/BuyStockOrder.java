package design_pattern.behavioral.command.order;

import design_pattern.behavioral.command.Stock;

public class BuyStockOrder implements Order {
	private Stock absStock;

	public BuyStockOrder(Stock absStock) {
		this.absStock = absStock;
	}

	@Override
	public void execute() {
		absStock.buy();
	}
}
