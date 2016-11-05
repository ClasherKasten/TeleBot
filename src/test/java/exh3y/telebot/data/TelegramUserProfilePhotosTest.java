package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramUserProfilePhotosTest {

	@Test
	public void testUserProfilePhotosCreation() {

		String userProfilePhotosString = "{\"total_count\":3, \"photos\":[[{\"file_id\":\"af5cb16390\", \"width\":1920, \"height\":1080, \"file_size\":128},{\"file_id\":\"28abffc\", \"width\":1920, \"height\":1080, \"file_size\":256}],[{\"file_id\":\"21554aab\", \"width\":512, \"height\":628, \"file_size\":128},{\"file_id\":\"2455hfd\", \"width\":1920, \"height\":1080, \"file_size\":128}]]}";
		JSONObject json = new JSONObject(userProfilePhotosString);

		TelegramUserProfilePhotos userProfilePhotos;
		try {
			userProfilePhotos = TelegramUserProfilePhotos.create(json);
		} catch (IOException e) {
			assertTrue(false);
			return;
		}

		assertEquals((int) userProfilePhotos.getTotal_count(), json.getInt("total_count"));
	}

}
