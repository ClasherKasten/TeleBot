package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

public class TelegramVoiceTest {

    @Test
    public void testVoiceCreation() {

        String voiceString = "{\"file_id\":\"1ba546aafc\", \"duration\":12}";
        JSONObject json = new JSONObject(voiceString);

        TelegramVoice voice;
        try {
            voice = TelegramVoice.create(json);
        } catch (IOException e) {
            assertTrue(false);
            return;
        }

        assertEquals(voice.getFile_id(), json.getString("file_id"));
        assertEquals((int) voice.getDuration(), json.getInt("duration"));
    }
}
