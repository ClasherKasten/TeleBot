package exh3y.telebot.actions;

import org.json.JSONObject;

/**
 * Handles messages sent to the bot.
 * 
 * @since 0.0.1
 */
public interface TelegramActionHandler {

	/**
	 * The main method containing the action to execute.
	 * 
	 * @param responseObject
	 *            The 'message' part of the response object
	 * @since 0.0.1
	 */
	void onCommandReceive(int chatId, JSONObject message);

}
