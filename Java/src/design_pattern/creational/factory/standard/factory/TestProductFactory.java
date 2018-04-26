package design_pattern.creational.factory.standard.factory;

import design_pattern.creational.factory.standard.p.Product;
import design_pattern.creational.factory.standard.p.TestProduct;

public class TestProductFactory extends ProductFactory {
	@Override
	public Product method() {
		return new TestProduct();
	}
}
