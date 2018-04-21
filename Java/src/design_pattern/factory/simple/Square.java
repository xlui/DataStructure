package design_pattern.factory.simple;

public class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method");
	}
}
