package design_pattern.abstract_factory.shape;

public class SquareShape implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside SquareShape.draw() method");
	}
}
