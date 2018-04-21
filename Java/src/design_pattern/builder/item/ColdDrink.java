package design_pattern.builder.item;

import design_pattern.builder.Item;
import design_pattern.builder.pack.Bottle;
import design_pattern.builder.pack.Packing;

public abstract class ColdDrink implements Item {
	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
