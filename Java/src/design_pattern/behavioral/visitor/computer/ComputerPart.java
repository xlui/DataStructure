package design_pattern.behavioral.visitor.computer;

import design_pattern.behavioral.visitor.ComputerPartVisitor;

public interface ComputerPart {
	void accept(ComputerPartVisitor computerPartVisitor);
}
