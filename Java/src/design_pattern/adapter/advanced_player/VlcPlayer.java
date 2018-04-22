package design_pattern.adapter.advanced_player;

public class VlcPlayer implements AdvancedMediaPlayer {
	@Override
	public void playVLC(String filename) {
		System.out.println("Playing vlc file. Name: " + filename);
	}

	@Override
	public void playMp4(String filename) {
		throw new RuntimeException("Does not support this format");
	}
}
