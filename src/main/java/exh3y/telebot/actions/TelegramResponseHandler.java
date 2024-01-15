package exh3y.telebot.actions;

import kong.unirest.json.JSONObject;

/**
 * Handles responses sent to the bot not containing a message (i.e. inline keyboard actions).
 *
 * @since 0.0.5
 */
public interface TelegramResponseHandler {

    /**
     * Gets called every time a response is received for every registered handler.
     *
     * @param response The response object
     * @since 0.0.5
     */
    void onReceive(JSONObject response);
}
