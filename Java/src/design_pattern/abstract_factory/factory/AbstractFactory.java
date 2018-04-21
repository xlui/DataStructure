package design_pattern.abstract_factory.factory;

import design_pattern.abstract_factory.color.Color;
import design_pattern.abstract_factory.shape.Shape;

public abstract class AbstractFactory {
	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);
}
