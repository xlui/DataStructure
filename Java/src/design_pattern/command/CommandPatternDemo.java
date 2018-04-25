package design_pattern.command;

import design_pattern.command.order.BuyStockOrder;
import design_pattern.command.order.SellStockOrder;

public class CommandPatternDemo {
	public static void main(String[] args) {
		Stock absStock = new Stock();
		BuyStockOrder buyStock = new BuyStockOrder(absStock);
		SellStockOrder sellStock = new SellStockOrder(absStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStock);
		broker.takeOrder(sellStock);
		broker.placeOrders();
	}

}
