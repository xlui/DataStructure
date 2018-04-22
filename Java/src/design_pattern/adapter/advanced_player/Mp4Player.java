package design_pattern.adapter.advanced_player;

public class Mp4Player implements AdvancedMediaPlayer {
	@Override
	public void playVLC(String filename) {
		throw new RuntimeException("Does not support this method.");
	}

	@Override
	public void playMp4(String filename) {
		System.out.println("Pleaying mp4 file. Name: " + filename);
	}
}
