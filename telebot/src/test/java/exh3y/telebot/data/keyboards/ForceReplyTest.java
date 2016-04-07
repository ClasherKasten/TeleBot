package exh3y.telebot.data.keyboards;

import static org.junit.Assert.assertFalse;

import org.json.JSONObject;
import org.junit.Test;

public class ForceReplyTest {

	@Test
	public void testKeyboardCreation() {
		
		new ForceReply(false);
	}
	
	@Test
	public void testToJSONString() {
		
		ForceReply keyboard = new ForceReply(false);
		
		JSONObject json = new JSONObject(keyboard.toJSONString());
		assertFalse(json.getBoolean("selective"));
	}
	
}
