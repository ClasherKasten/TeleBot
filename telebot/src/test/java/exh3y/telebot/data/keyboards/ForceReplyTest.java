package exh3y.telebot.data.keyboards;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

public class ForceReplyTest {

	@Test
	public void testKeyboardCreation() {
		
		new ForceReply(false);
	}
	
	@Test
	public void testToJSONString() {
		
		ForceReply keyboard = new ForceReply(true);
		
		JSONObject json = new JSONObject(keyboard.toJSONString());
		assertTrue(json.getBoolean("selective"));
	}
	
}
