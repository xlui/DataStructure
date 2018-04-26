package design_pattern.behavioral.template;

public class FootballGame extends AbstractGame {
	@Override
	public void initialize() {
		System.out.println("Football Game Initialized! Start playing.");
	}

	@Override
	public void startPlay() {
		System.out.println("Footbal Game Started! Enjoy the game.");
	}

	@Override
	public void endPlay() {
		System.out.println("Football Game Finished!");
	}
}
