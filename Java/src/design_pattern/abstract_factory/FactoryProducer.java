package design_pattern.abstract_factory;

import design_pattern.abstract_factory.factory.AbstractFactory;
import design_pattern.abstract_factory.factory.ColorFactory;
import design_pattern.abstract_factory.factory.ShapeFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String factory) {
		if (factory.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if (factory.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}
}
