package design_pattern.visitor;

import design_pattern.visitor.computer.Computer;
import design_pattern.visitor.computer.ComputerPart;

public class VisitorPatternDemo {
	public static void main(String[] args) {
		ComputerPart computerPart = new Computer();
		computerPart.accept(new ComputerPartDisplayVisitor());
	}
}
