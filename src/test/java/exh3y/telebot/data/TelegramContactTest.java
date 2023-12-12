package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

public class TelegramContactTest {

    @Test
    public void testContactCreation() {

        String contactString = "{\"phone_number\":\"0123456789\",\"first_name\":\"ABQC\"}";
        JSONObject json = new JSONObject(contactString);

        TelegramContact contact;
        try {
            contact = TelegramContact.create(json);
        } catch (IOException e) {
            assertTrue("JSON parsing is working like expected", false);
            return;
        }

        assertEquals(contact.getPhone_number(), json.getString("phone_number"));
        assertEquals(contact.getFirst_name(), json.getString("first_name"));
    }
}
