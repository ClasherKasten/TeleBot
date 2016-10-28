package exh3y.telebot.data;

import org.json.JSONObject;

public class TelegramMessage extends JSONObject {

	private TelegramChat chat;
	
	/**
	 * <p>
	 * Creates a new TelegramMessage object from a given JSON-String
	 * </p>
	 * 
	 * @param message
	 * @since 0.0.3
	 */
	public TelegramMessage(JSONObject message) {

		super(message.toString());
		chat = new TelegramChat(this.getJSONObject("chat"));
	}

	/**
	 * <p>
	 * Returns the command as array.
	 * </p>
	 * 
	 * @return The command as array
	 * @since 0.0.3
	 */
	public String[] toCommandArray() {

		return this.getString("text").split(" ");
	}

	/**
	 * <p>
	 * Returns the message's text field.
	 * </p>
	 * 
	 * @return The content of 'text'
	 * @since 0.0.3
	 */
	public String getText() {

		return this.getString("text");
	}

	/**
	 * <p>
	 * Returns the chatId of the current message.
	 * </p>
	 * 
	 * @return The chatID
	 * @since 0.0.3
	 * @deprecated You should use the methods provided by TelegramChat using message.getChat().
	 */
	public int getChatId() {

		return this.chat.getId();
	}

	/**
	 * <p>
	 * Returns the messageId of the current message.
	 * </p>
	 * 
	 * @return The chatID
	 * @since 0.0.3
	 */
	public int getMessageId() {

		return this.getInt("message_id");
	}

	/**
	 * Returns the message's chat type
	 * 
	 * @return The type of the chat
	 * @since 0.0.5
	 * @deprecated You should use the methods provided by TelegramChat using message.getChat().
	 */
	public String getChatType() {

		return this.chat.getString("type");
	}
	
	/**
	 * Returns the message's chat
	 * 
	 * @return The chat
	 * @since 0.0.6
	 */
	public TelegramChat getChat() {
		
		return chat;
	}

}
