package design_pattern.behavioral.visitor;

import design_pattern.behavioral.visitor.computer.Computer;
import design_pattern.behavioral.visitor.computer.Keyboard;
import design_pattern.behavioral.visitor.computer.Monitor;
import design_pattern.behavioral.visitor.computer.Mouse;

public interface ComputerPartVisitor {
	void visit(Computer computer);

	void visit(Mouse mouse);

	void visit(Keyboard keyboard);

	void visit(Monitor monitor);
}
