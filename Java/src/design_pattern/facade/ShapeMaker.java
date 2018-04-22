package design_pattern.facade;

import design_pattern.facade.shape.Circle;
import design_pattern.facade.shape.Rectangle;
import design_pattern.facade.shape.Shape;
import design_pattern.facade.shape.Square;

public class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMaker() {
		this.circle = new Circle();
		this.rectangle = new Rectangle();
		this.square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}
