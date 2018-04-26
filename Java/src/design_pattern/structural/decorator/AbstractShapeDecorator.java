package design_pattern.structural.decorator;

import design_pattern.structural.decorator.shape.Shape;

public abstract class AbstractShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public AbstractShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
	}
}
