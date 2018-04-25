package design_pattern.observer.observer;

import design_pattern.observer.Subject;

public abstract class Observer {
	protected Subject subject;

	public abstract void update();
}
