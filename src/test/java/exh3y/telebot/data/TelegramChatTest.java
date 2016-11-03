package exh3y.telebot.data;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

import exh3y.telebot.data.enums.ETelegramChatType;

public class TelegramChatTest {

	@Test
	public void testChatCreation() {
		
		String[] types = {"private", "group", "supergroup", "channel"};
		
		for (String type : types) {

			JSONObject json = new JSONObject("{\"id\":12,\"type\":\"" + type + "\",\"username\":\"some user\"}");
			TelegramChat chat;
			try {
				chat = TelegramChat.create(json);
			} catch (IOException e) {
				e.printStackTrace();
				assertTrue(false);
				return;
			}
			
			assertEquals(chat.getId(), 12);
			assertEquals(chat.getType(), ETelegramChatType.getEnumByName(type));
			assertEquals(chat.getUsername(), "some user");
			
		}
		
	}
	
}
