package design_pattern.creational.factory.standard.factory;

import design_pattern.creational.factory.standard.p.ConcreteProduct;
import design_pattern.creational.factory.standard.p.Product;

public class ConcreteProductFactory extends ProductFactory {
	@Override
	public Product method() {
		return new ConcreteProduct();
	}
}
