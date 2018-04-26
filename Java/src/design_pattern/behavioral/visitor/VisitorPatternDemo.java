package design_pattern.behavioral.visitor;

import design_pattern.behavioral.visitor.computer.Computer;
import design_pattern.behavioral.visitor.computer.ComputerPart;

public class VisitorPatternDemo {
	public static void main(String[] args) {
		ComputerPart computerPart = new Computer();
		computerPart.accept(new ComputerPartDisplayVisitor());
	}
}
