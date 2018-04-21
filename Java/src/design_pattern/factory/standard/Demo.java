package design_pattern.factory.standard;

import design_pattern.factory.standard.factory.ConcreteProductFactory;
import design_pattern.factory.standard.factory.ProductFactory;
import design_pattern.factory.standard.factory.TestProductFactory;
import design_pattern.factory.standard.p.Product;

public class Demo {
	public static void main(String[] args) {
		ProductFactory concreteProductFactory = new ConcreteProductFactory();
		ProductFactory testProductFactory = new TestProductFactory();
		Product concreteProduct = concreteProductFactory.method();
		Product testProduct = testProductFactory.method();

		concreteProduct.use();
		testProduct.use();
	}
}
