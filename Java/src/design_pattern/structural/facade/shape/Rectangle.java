package design_pattern.structural.facade.shape;

public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
	}
}
