package design_pattern.creational.abstract_factory.factory;

import design_pattern.creational.abstract_factory.color.Color;
import design_pattern.creational.abstract_factory.shape.CircleShape;
import design_pattern.creational.abstract_factory.shape.RectangleShape;
import design_pattern.creational.abstract_factory.shape.Shape;
import design_pattern.creational.abstract_factory.shape.SquareShape;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		return null;
	}

	@Override
	public Shape getShape(String shape) {
		if (shape == null) {
			return null;
		}

		if (shape.equalsIgnoreCase("CIRCLE")) {
			return new CircleShape();
		} else if (shape.equalsIgnoreCase("RECTANGLE")) {
			return new RectangleShape();
		} else if (shape.equalsIgnoreCase("SQUARE")) {
			return new SquareShape();
		}

		return null;
	}
}
