package design_pattern.visitor.computer;

import design_pattern.visitor.ComputerPartVisitor;

public class Keyboard implements ComputerPart {
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}
