package design_pattern.creational.builder;

import design_pattern.creational.builder.pack.Packing;

public interface Item {
	String name();

	Packing packing();

	float price();
}
