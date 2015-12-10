package exh3y.telebot.util;

import org.json.JSONObject;

public class TelegramMessage extends JSONObject {

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
	public String[] toCommandArray() {

		return this.getString("text").split(" ");
	}
	
	public int getChatId() {
		
		return this.getJSONObject("chat").getInt("id");
	}

}
