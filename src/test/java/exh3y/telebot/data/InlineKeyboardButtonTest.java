package exh3y.telebot.data;

import static org.junit.Assert.*;

import exh3y.telebot.data.keyboards.InlineKeyboardButton;

import org.json.JSONObject;
import org.junit.Test;

public class InlineKeyboardButtonTest {

    @Test
    public void testInlineKeyboardButtonCreation() {

        InlineKeyboardButton callbackButton =
                new InlineKeyboardButton("Some button", null, "data to be sent", null);
        InlineKeyboardButton urlButton =
                new InlineKeyboardButton("Another button", "http://www.example.com", null, null);
        InlineKeyboardButton switchInlineButton =
                new InlineKeyboardButton("Chat button", null, null, "let me help you");

        InlineKeyboardButton defaultButton = new InlineKeyboardButton("Default button");

        JSONObject callback = new JSONObject(callbackButton.toJSONString());
        assertTrue(callbackButton.getCallbackData().equals(callback.getString("callback_data")));

        JSONObject url = new JSONObject(urlButton.toJSONString());
        assertTrue(urlButton.getUrl().equals(url.getString("url")));

        JSONObject switchInline = new JSONObject(switchInlineButton.toJSONString());
        assertTrue(
                switchInlineButton
                        .getSwitchInlineQuery()
                        .equals(switchInline.getString("switch_inline_query")));

        JSONObject button = new JSONObject(defaultButton.toJSONString());
        assertTrue(defaultButton.getText().equals(button.getString("text")));
    }
}
