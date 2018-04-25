package design_pattern.visitor;

import design_pattern.visitor.computer.Computer;
import design_pattern.visitor.computer.Keyboard;
import design_pattern.visitor.computer.Monitor;
import design_pattern.visitor.computer.Mouse;

public interface ComputerPartVisitor {
	void visit(Computer computer);

	void visit(Mouse mouse);

	void visit(Keyboard keyboard);

	void visit(Monitor monitor);
}
