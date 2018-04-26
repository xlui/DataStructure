package design_pattern.creational.abstract_factory.color;

public class GreenColor implements Color {
	@Override
	public void fill() {
		System.out.println("Inside GreenColor.fill() method");
	}
}
