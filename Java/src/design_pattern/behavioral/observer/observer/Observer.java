package design_pattern.behavioral.observer.observer;

import design_pattern.behavioral.observer.Subject;

public abstract class Observer {
	protected Subject subject;

	public abstract void update();
}
