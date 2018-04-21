package design_pattern.factory.standard.p;

public class TestProduct implements Product {
	@Override
	public void use() {
		System.out.println("Inside TestProduct.use() method");
	}
}
