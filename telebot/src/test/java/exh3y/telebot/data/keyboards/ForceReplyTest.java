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

		ForceReply selectiveKeyboard = new ForceReply(true);

		JSONObject json = new JSONObject(selectiveKeyboard.toJSONString());
		assertTrue(json.getBoolean("selective"));

		ForceReply nonSelectiveKeyboard = new ForceReply(false);

		json = new JSONObject(nonSelectiveKeyboard.toJSONString());
		assertFalse(json.optBoolean("selective", false));
	}

}
