package exh3y.telebot.data;

import org.json.JSONObject;

import exh3y.telebot.data.enums.ETelegramChatType;

public class TelegramChat extends JSONObject {

	private ETelegramChatType type;
	
	/**
	 * Creates a new TelegramChat object from a given JSON-String
	 * 
	 * @param chat
	 * @since 0.0.6
	 */
	public TelegramChat(JSONObject chat) {

		super(chat.toString());
		
		this.type = ETelegramChatType.getEnumByName(chat.getString("type"));
	}
	
	/**
	 * Returns the chat's type
	 * 
	 * @return The chat's type
	 * @since 0.0.6
	 */
	public ETelegramChatType getType() {
		
		return type;
	}
	
	/**
	 * Returns the chat's id
	 * 
	 * @return The chat's id
	 * @since 0.0.6
	 */
	public int getId() {
		
		return this.getInt("id");
	}
	
	/**
	 * Returns the chat's title
	 * 
	 * @return The title
	 * @since 0.0.6
	 */
	public String getTitle() {
		
		return this.getString("title");
	}
	
}
