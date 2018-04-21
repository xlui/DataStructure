package design_pattern.factory.standard.factory;

import design_pattern.factory.standard.p.Product;
import design_pattern.factory.standard.p.TestProduct;

public class TestProductFactory extends ProductFactory {
	@Override
	public Product method() {
		return new TestProduct();
	}
}
