package design_pattern.creational.builder.item;

import design_pattern.creational.builder.Item;
import design_pattern.creational.builder.pack.Bottle;
import design_pattern.creational.builder.pack.Packing;

public abstract class ColdDrink implements Item {
	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
