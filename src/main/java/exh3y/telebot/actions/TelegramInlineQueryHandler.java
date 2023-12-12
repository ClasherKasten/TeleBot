package exh3y.telebot.actions;

import org.json.JSONObject;

public interface TelegramInlineQueryHandler {

    /**
     * Gets called every time a inline request is sent to the bot.
     *
     * @param request The request
     */
    void onInlineReceive(JSONObject request);
}
