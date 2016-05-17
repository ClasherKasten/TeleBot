package exh3y.telebot.data.keyboards;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.json.JSONObject;
import org.junit.Test;

import exh3y.telebot.data.InlineKeyboardButton;
import exh3y.telebot.testutil.StringGenerator;

public class InlineKeyboardMarkupTest {

	@Test
	public void testInlineKeyboardMarkupCreation() {

		StringGenerator gen = new StringGenerator();
		Random rand = new Random();

		int lenght1 = rand.nextInt(10) + 1;
		int lenght2 = rand.nextInt(10) + 1;

		String[][] keyboard = new String[lenght1][lenght2];
		InlineKeyboardButton[][] buttons = new InlineKeyboardButton[lenght1][lenght2];

		for (int i = 0; i < keyboard.length; i++) {

			for (int j = 0; j < keyboard[i].length; j++) {

				String text = gen.randomString(rand.nextInt(20) + 1, true);
				keyboard[i][j] = text;
				buttons[i][j] = new InlineKeyboardButton(text);

			}

		}

		InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(keyboard);
		// TODO: Check if generated markup contains all buttons

		InlineKeyboardMarkup buttonMarkup = new InlineKeyboardMarkup(buttons);
		assertTrue(buttonMarkup.keyboard.equals(buttons));
	}

	@Test
	public void testToJsonString() {

		StringGenerator gen = new StringGenerator();
		Random rand = new Random();

		int lenght1 = rand.nextInt(10) + 1;
		int lenght2 = rand.nextInt(10) + 1;

		InlineKeyboardButton[][] buttons = new InlineKeyboardButton[lenght1][lenght2];

		for (int i = 0; i < buttons.length; i++) {

			for (int j = 0; j < buttons[i].length; j++) {

				String text = gen.randomString(rand.nextInt(20) + 1, true);
				buttons[i][j] = new InlineKeyboardButton(text);

			}

		}

		InlineKeyboardMarkup buttonMarkup = new InlineKeyboardMarkup(buttons);
		JSONObject json = new JSONObject(buttonMarkup.toJSONString());
		
		//TODO: Check if json object holds the correct information

	}

}
