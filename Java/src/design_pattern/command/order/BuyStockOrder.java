package design_pattern.command.order;

import design_pattern.command.Stock;

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
