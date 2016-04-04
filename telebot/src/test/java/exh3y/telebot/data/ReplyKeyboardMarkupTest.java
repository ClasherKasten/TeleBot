package exh3y.telebot.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReplyKeyboardMarkupTest {

	@Test
	public void testKeyboardCreation() {

		String[][] keyboard = { { "1-1", "1-2", "1-3" }, { "2-1", "2-2", "2-3" }, { "3-1", "3-2", "3-3" } };
		ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard);

		assertTrue(markup.keyboard.equals(keyboard));
		assertTrue(markup.oneTimeKeyboard == false);

	}

	@Test
	public void testToJSONString() {

		String[][] keyboard = { { "a" }, { "b" }, { "c" } };
		ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard);

		try {
			markup.toJSONString();
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
