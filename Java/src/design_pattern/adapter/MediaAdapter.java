package design_pattern.adapter;

import design_pattern.adapter.advanced_player.AdvancedMediaPlayer;
import design_pattern.adapter.advanced_player.Mp4Player;
import design_pattern.adapter.advanced_player.VlcPlayer;
import design_pattern.adapter.player.MediaPlayer;

public class MediaAdapter implements MediaPlayer {
	private AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("VLC")) {
			advancedMediaPlayer = new VlcPlayer();
		} else if (audioType.equalsIgnoreCase("MP4")) {
			advancedMediaPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String filename) {
		if (audioType.equalsIgnoreCase("VLC")) {
			advancedMediaPlayer.playVLC(filename);
		} else if (audioType.equalsIgnoreCase("MP4")) {
			advancedMediaPlayer.playMp4(filename);
		}
	}
}
