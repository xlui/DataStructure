package design_pattern.builder;

import design_pattern.builder.pack.Packing;

public interface Item {
	String name();

	Packing packing();

	float price();
}
