package design_pattern.behavioral.mediator;

import java.util.Date;

public class ChatRoom {
	public static void showMessage(User user, String message) {
		System.out.println(new Date().toInstant() + " [" + user.getName() + "]: " + message);
	}
}
