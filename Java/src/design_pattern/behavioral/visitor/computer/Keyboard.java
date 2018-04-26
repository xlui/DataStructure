package design_pattern.behavioral.visitor.computer;

import design_pattern.behavioral.visitor.ComputerPartVisitor;

public class Keyboard implements ComputerPart {
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}
