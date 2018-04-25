package design_pattern.template;

public class TemplatePatternDemo {
	public static void main(String[] args) {
		AbstractGame game = new CricketGame();
		game.play();
		System.out.println();

		game = new FootballGame();
		game.play();
	}
}
