package design_pattern.builder;

import design_pattern.builder.item.ChickenBurger;
import design_pattern.builder.item.Coke;
import design_pattern.builder.item.Pepsi;
import design_pattern.builder.item.VegBurger;

public class MealBuilder {
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}

	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
