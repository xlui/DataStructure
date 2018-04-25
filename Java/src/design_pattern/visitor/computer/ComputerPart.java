package design_pattern.visitor.computer;

import design_pattern.visitor.ComputerPartVisitor;

public interface ComputerPart {
	void accept(ComputerPartVisitor computerPartVisitor);
}
