package exh3y.telebot.actions;

import org.json.JSONObject;

/**
 * Gets called if there is no handler available for the given response type.
 * 
 * @author EXH3Y
 */
public interface TelegramCommonHandler {

	void onCommandReceive(JSONObject response);

}
