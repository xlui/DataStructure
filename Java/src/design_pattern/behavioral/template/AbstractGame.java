package design_pattern.behavioral.template;

public abstract class AbstractGame {
	public abstract void initialize();

	public abstract void startPlay();

	public abstract void endPlay();

	public final void play() {
		initialize();
		startPlay();
		endPlay();
	}
}
