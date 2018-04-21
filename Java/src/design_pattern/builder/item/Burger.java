package design_pattern.builder.item;

import design_pattern.builder.Item;
import design_pattern.builder.pack.Packing;
import design_pattern.builder.pack.Wrapper;

public abstract class Burger implements Item {
	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
}
