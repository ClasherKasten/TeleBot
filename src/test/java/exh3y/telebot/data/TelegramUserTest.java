package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramUserTest {

	@Test
	public void testUserCreation() {

		JSONObject user = new JSONObject("{\"id\":1, \"first_name\":\"test\",\"username\":\"another test\"}");

		TelegramUser tUser;
		try {
			tUser = TelegramUser.create(user);
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
			return;
		}

		assertEquals(tUser.getId(), 1);
		assertEquals(tUser.getFirst_name(), "test");
		assertEquals(tUser.getUsername(), "another test");

		assertFalse(tUser.hasLast_name());
	}

}
