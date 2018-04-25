package design_pattern.visitor;

import design_pattern.visitor.computer.Computer;
import design_pattern.visitor.computer.Keyboard;
import design_pattern.visitor.computer.Monitor;
import design_pattern.visitor.computer.Mouse;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
	@Override
	public void visit(Computer computer) {
		System.out.println("Displaying Computer.");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying Mouse.");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying Keyboard.");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Displaying Monitor.");
	}
}
