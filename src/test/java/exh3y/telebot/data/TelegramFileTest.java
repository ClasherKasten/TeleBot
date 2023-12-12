package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

public class TelegramFileTest {

    @Test
    public void testFileCreation() {

        String fileString = "{\"file_id\":\"abba264bf53c\",\"file_size\":1234}";
        JSONObject json = new JSONObject(fileString);

        TelegramFile file;
        try {
            file = TelegramFile.create(json);
        } catch (IOException e) {
            assertTrue(false);
            return;
        }

        assertEquals(file.getFile_id(), json.getString("file_id"));
        assertEquals((int) file.getFile_size(), json.getInt("file_size"));
    }
}
