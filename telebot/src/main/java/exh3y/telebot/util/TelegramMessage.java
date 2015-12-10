package exh3y.telebot.util;

import org.json.JSONObject;

public class TelegramMessage {

	/**
	 * <p>
	 * Returns the command as array.
	 * </p>
	 * 
	 * @param message
	 *            The message object
	 * @return The command as array
	 * @since 0.0.3
	 */
	public static String[] messageToCommandArray(JSONObject message) {

		return message.getString("text").split(" ");
	}

}
