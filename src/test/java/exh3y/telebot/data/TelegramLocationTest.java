package exh3y.telebot.data;

import static org.junit.Assert.assertTrue;

import kong.unirest.json.JSONObject;

import org.junit.Test;

import java.io.IOException;

public class TelegramLocationTest {

    @Test
    public void testLocationCreation() {

        String locationString = "{\"longitude\":12.01257, \"latitude\":54.12514}";
        JSONObject json = new JSONObject(locationString);

        try {
            TelegramLocation.create(json);
        } catch (IOException e) {
            assertTrue(false);
            return;
        }
    }
}
