package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.JSONObject;

public class TelegramMessage extends JSONObject {

	private TelegramChat chat;
	
	/**
	 * <p>
	 * Creates a new TelegramMessage object from a given JSON-String
	 * </p>
	 * 
	 * @param message
	 * @throws IOException 
	 * @throws JSONException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @since 0.0.3
	 */
	public TelegramMessage(JSONObject message) throws JsonParseException, JsonMappingException, JSONException, IOException {

		super(message.toString());
		chat = TelegramChat.create(this.getJSONObject("chat"));
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

		return this.chat.getType().name();
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
