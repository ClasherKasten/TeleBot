package exh3y.telebot.data.keyboards;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

public class ReplyKeyboardHideTest {
	
	@Test
	public void testKeyboardCreation() {
		
		new ReplyKeyboardHide(false);
	}
	
	@Test
	public void testToJSONString() {
		
		ReplyKeyboardHide keyboard = new ReplyKeyboardHide(false);
		
		JSONObject json = new JSONObject(keyboard.toJSONString());
		assertFalse(json.getBoolean("selective"));
	}

}
