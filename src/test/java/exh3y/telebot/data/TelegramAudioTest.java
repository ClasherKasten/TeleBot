package exh3y.telebot.data;

import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramAudioTest {

	private String[] testValues = { "{\"file_id\":\"2af164d8783f\",\"duration\":2}",
			"{\"file_id\":\"a2faaa5461b21\",\"duration\":8,\"title\":\"My audio message\"}" };

	@Test
	public void testAudioCreation() {

		for (String string : testValues) {

			JSONObject json = new JSONObject(string);
			TelegramAudio audio;
			try {
				audio = TelegramAudio.create(json);
			} catch (IOException e) {
				assertTrue("JSON parsing is working like expected", false);
				return;
			}

			assertEquals(audio.getFile_id(), json.getString("file_id"));
			assertEquals((int) audio.getDuration(), json.getInt("duration"));

			if (audio.hasTitle()) {
				assertEquals(audio.getTitle(), json.getString("title"));
			}
		}
	}

}
