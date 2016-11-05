package exh3y.telebot.actions;

import exh3y.telebot.data.TelegramMessage;

/**
 * Handles messages sent to the bot.
 * 
 * @since 0.0.1
 */
public interface TelegramActionHandler {

	/**
	 * The main method containing the action to execute.
	 * 
	 * @param message
	 *            The message
	 * @since 0.1.0
	 */
	void onMessageReceive(TelegramMessage message);

}
