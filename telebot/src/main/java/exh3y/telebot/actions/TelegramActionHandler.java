package exh3y.telebot.actions;

import org.json.JSONObject;

public interface TelegramActionHandler {

	/**
	 * <p>
	 * The main method containing the action to execute.
	 * </p>
	 * 
	 * @param responseObject
	 *            The 'message' part of the response object
	 * @since 0.0.1
	 */
	void onCommandReceive(int chatId, JSONObject message);

}
