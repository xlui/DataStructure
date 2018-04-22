package design_pattern.decorator;

import design_pattern.decorator.shape.Shape;

public class RedShapeDecorator extends AbstractShapeDecorator {
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		super.draw();
		setRedBorder(decoratedShape);

	}

	private void setRedBorder(Shape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}
