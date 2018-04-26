package design_pattern.behavioral.mediator;

public class MediatorPatternDemo {
	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("john");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}
}
