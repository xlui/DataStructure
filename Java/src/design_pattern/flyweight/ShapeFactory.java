package design_pattern.flyweight;

import design_pattern.flyweight.shape.Circle;
import design_pattern.flyweight.shape.Shape;

import java.util.HashMap;

public class ShapeFactory {
	private static final HashMap<String, Shape> map = new HashMap<>();

	public static Shape getCircle(String color) {
		Shape circle = map.get(color);
		if (circle == null) {
			circle = new Circle(color);
			map.put(color, circle);
			System.out.println("Creating circle of color: " + color);
		}
		return circle;
	}
}
