package design_pattern.abstract_factory.color;

public class BlueColor implements Color {
	@Override
	public void fill() {
		System.out.println("Inside BlueColor.fill() method");
	}
}
