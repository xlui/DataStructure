package design_pattern.behavioral.template;

public class CricketGame extends AbstractGame {
	@Override
	public void initialize() {
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	public void startPlay() {
		System.out.println("Cricket Game Started. Enjoy the game!");
	}

	@Override
	public void endPlay() {
		System.out.println("Cricket Game Finished!");
	}
}
