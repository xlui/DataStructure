package design_pattern.factory.standard.p;

public class ConcreteProduct implements Product {
	@Override
	public void use() {
		System.out.println("Inside ConcreteProduct.use() method");
	}
}
