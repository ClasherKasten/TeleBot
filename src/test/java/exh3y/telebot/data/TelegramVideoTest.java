package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramVideoTest {

	@Test
	public void testVideoCreation() {

		String videoString = "{\"file_id\":\"1bac48ff2d\", \"width\": 1920, \"height\": 1080, \"duration\": 40}";
		JSONObject json = new JSONObject(videoString);

		TelegramVideo video;
		try {
			video = TelegramVideo.create(json);
		} catch (IOException e) {
			assertTrue(false);
			return;
		}

		assertEquals(video.getFile_id(), json.getString("file_id"));
		assertEquals((int) video.getWidth(), json.getInt("width"));
		assertEquals((int) video.getHeight(), json.getInt("height"));
		assertEquals((int) video.getDuration(), json.getInt("duration"));
	}

}
