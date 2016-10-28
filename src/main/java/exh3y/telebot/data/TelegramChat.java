package exh3y.telebot.data;

import org.json.JSONException;
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

		try {

			return this.getString("title");
		} catch (JSONException e) {
			return "";
		}
	}

	/**
	 * Returns the user's username
	 * 
	 * @return The user's username
	 * @since 0.0.6
	 */
	public String getUsername() {

		try {

			return this.getString("username");
		} catch (JSONException e) {
			return "";
		}
	}

	/**
	 * Returns the user's first name
	 * 
	 * @return The user's first name
	 * @since 0.0.6
	 */
	public String getFirstName() {

		try {

			return this.getString("first_name");
		} catch (JSONException e) {
			return "";
		}
	}

	/**
	 * Returns the user's last name
	 * 
	 * @return The user's last name
	 * @since 0.0.6
	 */
	public String getLastName() {

		try {

			return this.getString("last_name");
		} catch (JSONException e) {
			return "";
		}
	}

	/**
	 * Are all users administrators?
	 * 
	 * @return True if all users are administrators, false otherwise
	 * @since 0.0.6
	 */
	public boolean getAllUsersAreAdmins() {

		try {

			return this.getBoolean("all_members_are_administrators");
		} catch (JSONException e) {
			return false;
		}
	}

}
