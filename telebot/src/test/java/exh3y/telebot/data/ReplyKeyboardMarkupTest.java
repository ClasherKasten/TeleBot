package exh3y.telebot.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class ReplyKeyboardMarkupTest {

	@Test
	public void testKeyboardCreation() {
		
		String[][] keyboard = {{"1-1", "1-2", "1-3"}, {"2-1", "2-2", "2-3"}, {"3-1", "3-2", "3-3"}};
		ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard);
		
		assertTrue(markup.keyboard.equals(keyboard));
		assertTrue(markup.oneTimeKeyboard == false);
		
	}
	
}
