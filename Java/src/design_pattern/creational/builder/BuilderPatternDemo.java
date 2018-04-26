package design_pattern.creational.builder;

import design_pattern.creational.builder.item.ChickenBurger;
import design_pattern.creational.builder.item.Coke;
import design_pattern.creational.builder.item.Pepsi;
import design_pattern.creational.builder.item.VegBurger;

public class BuilderPatternDemo {
	public static void main(String[] args) {
		Meal vegMeal = new Meal.Builder()
				.addItem(new VegBurger())
				.addItem(new Coke())
				.build();
		Meal nonVegMeal = new Meal.Builder()
				.addItem(new ChickenBurger())
				.addItem(new Pepsi())
				.build();
	}

//	public static void main(String[] args) {
//		MealBuilder builder = new MealBuilder();
//
//		Meal vegMeal = builder.prepareVegMeal();
//		System.out.println("Veg Meal");
//		vegMeal.showItems();
//		System.out.println("Total cost: " + vegMeal.getCost());
//
//		Meal nonVegMeal = builder.prepareNonVegMeal();
//		System.out.println("\n\nNon-Veg Meal");
//		nonVegMeal.showItems();
//		System.out.println("Total cost: " + nonVegMeal.getCost());
//	}
}
