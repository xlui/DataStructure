package design_pattern.abstract_factory.color;

public class RedColor implements Color {
	@Override
	public void fill() {
		System.out.println("Inside RedColor.fill() method");
	}
}
