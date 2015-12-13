package exh3y.telebot.data;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramMessageTest {

	@Test
	public void testMessageCreation() {
		
		JSONObject json = new JSONObject("{\"message_id\":42,\"from\":{\"id\":547885,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\"},\"chat\":{\"id\":1337,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\",\"type\":\"private\"},\"date\":1450006107,\"text\":\"This is a test message.\"}");
		TelegramMessage telemessage = new TelegramMessage(json);
		
		assertTrue(telemessage.getText() == "This is a test message.");
		assertTrue(telemessage.getChatId() == 1337);
		
	}
	
}
