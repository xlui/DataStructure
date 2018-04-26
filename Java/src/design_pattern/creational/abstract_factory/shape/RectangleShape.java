package design_pattern.creational.abstract_factory.shape;

public class RectangleShape implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside RectangleShape.draw() method");
	}
}
