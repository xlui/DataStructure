package design_pattern.creational.abstract_factory;

import design_pattern.creational.abstract_factory.color.Color;
import design_pattern.creational.abstract_factory.factory.AbstractFactory;
import design_pattern.creational.abstract_factory.shape.Shape;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		assert shapeFactory != null;
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape1.draw();
		shape2.draw();
		shape3.draw();

		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		assert colorFactory != null;
		Color color1 = colorFactory.getColor("RED");
		Color color2 = colorFactory.getColor("GREEN");
		Color color3 = colorFactory.getColor("BLUE");
		color1.fill();
		color2.fill();
		color3.fill();
	}
}
