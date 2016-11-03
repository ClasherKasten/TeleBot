package exh3y.telebot.data;

import java.io.IOException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import exh3y.telebot.data.enums.ETelegramChatType;

public class TelegramChat {

	private int					id;
	private ETelegramChatType	type;

	private Optional<String>	title;
	private Optional<String>	username;
	private Optional<String>	first_name;
	private Optional<String>	last_name;
	private Optional<Boolean>	all_members_are_administrators;

	public static TelegramChat create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramChat.class);
	}

	@Override
	public boolean equals(Object obj) {

		if (super.equals(obj)) {
			return true;
		}

		if (obj instanceof TelegramChat) {
			return ((TelegramChat) obj).getId() == this.getId();
		}

		return false;
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

		return this.id;
	}

	public boolean hasTitle() {

		return this.title.isPresent();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {

		return title.get();
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {

		this.title = Optional.of(title);
	}

	public boolean hasUsername() {

		return this.username.isPresent();
	}

	/**
	 * @return the username
	 */
	public String getUsername() {

		return username.get();
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {

		this.username = Optional.of(username);
	}

	public boolean hasFirst_name() {

		return this.first_name.isPresent();
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {

		return first_name.get();
	}

	/**
	 * @param first_name
	 *            the first_name to set
	 */
	public void setFirst_name(String first_name) {

		this.first_name = Optional.of(first_name);
	}

	public boolean hasLast_name() {

		return this.last_name.isPresent();
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {

		return last_name.get();
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {

		this.last_name = Optional.of(last_name);
	}

	/**
	 * @return the all_members_are_administrators
	 */
	public Boolean getAll_members_are_administrators() {

		return all_members_are_administrators.orElse(false);
	}

	/**
	 * @param all_members_are_administrators
	 *            the all_members_are_administrators to set
	 */
	public void setAll_members_are_administrators(Boolean all_members_are_administrators) {

		this.all_members_are_administrators = Optional.of(all_members_are_administrators);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {

		this.id = id;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = ETelegramChatType.getEnumByName(type);
	}

}
