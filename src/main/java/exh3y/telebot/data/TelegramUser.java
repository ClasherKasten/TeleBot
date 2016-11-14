package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramUser {

	private int		id;
	private String	first_name;

	private String	last_name	= null;
	private String	username	= null;

	public static TelegramUser create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramUser.class);
	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getFirst_name() {

		return first_name;
	}

	public void setFirst_name(String first_name) {

		this.first_name = first_name;
	}

	public boolean hasLast_name() {

		return last_name != null;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {

		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {

		this.last_name = last_name;
	}

	public boolean hasUsername() {

		return username != null;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {

		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {

		this.username = username;
	}

}
