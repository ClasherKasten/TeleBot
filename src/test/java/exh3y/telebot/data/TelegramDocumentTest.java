package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import kong.unirest.json.JSONObject;

import org.junit.Test;

import java.io.IOException;

public class TelegramDocumentTest {

    @Test
    public void testDocumentCreation() {

        String documentString = "{\"file_id\":\"afc345119abb\",\"file_name\":\"My file\"}";
        JSONObject json = new JSONObject(documentString);

        TelegramDocument document;
        try {
            document = TelegramDocument.create(json);
        } catch (IOException e) {
            assertTrue("JSON parsing is working like expected", false);
            return;
        }

        assertEquals(document.getFile_id(), json.getString("file_id"));
        assertEquals(document.getFile_name(), json.getString("file_name"));
    }
}
