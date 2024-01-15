package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import kong.unirest.json.JSONObject;

import org.junit.Test;

import java.io.IOException;

public class TelegramMessageEntityTest {

    @Test
    public void testMessageEntityCreation() {

        String messageEntityString = "{\"type\":\"mention\",\"offset\":1,\"length\":5}";
        JSONObject json = new JSONObject(messageEntityString);

        TelegramMessageEntity messageEntity;
        try {
            messageEntity = TelegramMessageEntity.create(json);
        } catch (IOException e) {
            assertTrue(false);
            return;
        }

        assertEquals(messageEntity.getType(), json.getString("type"));
        assertEquals(messageEntity.getOffset(), json.getInt("offset"));
        assertEquals(messageEntity.getLength(), json.getInt("length"));
    }
}
