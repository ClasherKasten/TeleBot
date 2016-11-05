package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramUser {

	private int					id;
	private String				first_name;
	private Optional<String>	last_name	= Optional.empty();
	private Optional<String>	username	= Optional.empty();

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

	public String getLast_name() throws NoSuchElementException {

		return last_name.get();
	}

	public void setLast_name(String last_name) {

		this.last_name = Optional.of(last_name);
	}

	public boolean hasLast_name() {

		return this.last_name.isPresent();
	}

	public String getUsername() throws NoSuchElementException {

		return username.get();
	}

	public void setUsername(String username) {

		this.username = Optional.of(username);
	}

	public boolean hasUsername() {

		return this.username.isPresent();
	}

}
