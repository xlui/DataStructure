package design_pattern.abstract_factory.factory;

import design_pattern.abstract_factory.color.BlueColor;
import design_pattern.abstract_factory.color.Color;
import design_pattern.abstract_factory.color.GreenColor;
import design_pattern.abstract_factory.color.RedColor;
import design_pattern.abstract_factory.shape.Shape;

public class ColorFactory extends AbstractFactory {
	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}

		if (color.equalsIgnoreCase("RED")) {
			return new RedColor();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new GreenColor();
		} else if (color.equalsIgnoreCase("BLUE")) {
			return new BlueColor();
		}

		return null;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}
}
