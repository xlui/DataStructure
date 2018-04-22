package design_pattern.adapter;

import design_pattern.adapter.player.AudioPlayer;

public class AdapterPatternDemo {
	public static void main(String[] args) {
		AudioPlayer player = new AudioPlayer();

		player.play("mp3", "beyond the horizon.mp3");
		player.play("mp4", "alone.mp4");
		player.play("vlc", "far far away.vlc");
		player.play("avi", "mind me.avi");
	}
}
