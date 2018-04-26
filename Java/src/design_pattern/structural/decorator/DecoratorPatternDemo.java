package design_pattern.structural.decorator;

import design_pattern.structural.decorator.shape.Circle;
import design_pattern.structural.decorator.shape.Rectangle;
import design_pattern.structural.decorator.shape.Shape;

public class DecoratorPatternDemo {
	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape redCircle = new RedShapeDecorator(new Circle());
		Shape redRectangle = new RedShapeDecorator(new Rectangle());

		System.out.println("Circle with normal border");
		circle.draw();
		System.out.println("\nCircle with red border");
		redCircle.draw();
		System.out.println("\nRectangle with red border");
		redRectangle.draw();
	}
}
