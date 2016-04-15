package exh3y.telebot.data.keyboards;

import static org.junit.Assert.*;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import exh3y.telebot.testutil.StringGenerator;

public class ReplyKeyboardMarkupTest {

	@Test
	public void testKeyboardCreation() {

		StringGenerator gen = new StringGenerator();
		Random rand = new Random();

		String[][] keyboard = new String[rand.nextInt(10) + 1][rand.nextInt(10) + 1];

		for (int i = 0; i < keyboard.length; i++) {

			for (int j = 0; j < keyboard[i].length; j++) {

				keyboard[i][j] = gen.randomString(rand.nextInt(20) + 1, true);

			}

		}

		ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard);

		assertTrue(markup.keyboard.equals(keyboard));
		assertTrue(markup.oneTimeKeyboard == false);

	}

	@Test
	public void testToJSONString() {

		for (int count = 0; count < 10; count++) {

			StringGenerator gen = new StringGenerator();
			Random rand = new Random();

			String[][] keyboard = new String[rand.nextInt(10) + 1][rand.nextInt(10) + 1];

			for (int i = 0; i < keyboard.length; i++) {

				for (int j = 0; j < keyboard[i].length; j++) {

					keyboard[i][j] = gen.randomString(rand.nextInt(20) + 1, true);

				}

			}

			ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard);

			try {
				JSONObject object = new JSONObject(markup.toJSONString());

				JSONArray objectArray = object.getJSONArray("keyboard");
				JSONArray actualArray = new JSONArray(keyboard);

				assertTrue(objectArray.toString().equals(actualArray.toString()));

			} catch (Exception e) {
				assertTrue(false);
			}
		}
	}

}
