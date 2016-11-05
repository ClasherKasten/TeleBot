package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramStickerTest {

	@Test
	public void testStickerCreation() {

		String stickerString = "{\"file_id\":\"1a24b17cda\", \"width\": 520, \"height\": 120, \"emoji\": \"smile\"}";
		JSONObject json = new JSONObject(stickerString);

		TelegramSticker sticker;
		try {
			sticker = TelegramSticker.create(json);
		} catch (IOException e) {
			assertTrue(false);
			return;
		}

		assertEquals(sticker.getFile_id(), json.getString("file_id"));
		assertEquals((int) sticker.getWidth(), json.getInt("width"));
		assertEquals((int) sticker.getHeight(), json.getInt("height"));
		assertEquals(sticker.getEmoji(), json.getString("emoji"));
	}

}
