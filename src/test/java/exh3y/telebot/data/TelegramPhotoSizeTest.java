package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramPhotoSizeTest {

	@Test
	public void testPhotoSizeCreation() {

		String photoSizeString = "{\"file_id\":\"af5cb16390\", \"width\":1920, \"height\":1080, \"file_size\":128}";
		JSONObject json = new JSONObject(photoSizeString);

		TelegramPhotoSize photoSize;
		try {
			photoSize = TelegramPhotoSize.create(json);
		} catch (IOException e) {
			assertTrue(false);
			return;
		}

		assertEquals(photoSize.getFile_id(), json.getString("file_id"));
		assertEquals((int) photoSize.getWidth(), json.getInt("width"));
		assertEquals((int) photoSize.getHeight(), json.getInt("height"));
		assertEquals((int) photoSize.getFile_size(), json.getInt("file_size"));
	}

}
