package design_pattern.adapter.player;

import design_pattern.adapter.MediaAdapter;

public class AudioPlayer implements MediaPlayer {
	private MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String filename) {
		if (audioType.equalsIgnoreCase("MP3")) {
			System.out.println("Playing mp3 file. Name: " + filename);
		} else if (audioType.equalsIgnoreCase("VLC") || audioType.equalsIgnoreCase("MP4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, filename);
		} else {
			System.out.println("Invalid media. " + audioType + " format not supported!");
		}
	}
}
