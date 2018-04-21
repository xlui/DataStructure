package design_pattern.factory.standard.factory;

import design_pattern.factory.standard.p.ConcreteProduct;
import design_pattern.factory.standard.p.Product;

public class ConcreteProductFactory extends ProductFactory {
	@Override
	public Product method() {
		return new ConcreteProduct();
	}
}
