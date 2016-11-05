package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramContact {

	private String				phone_number;
	private String				first_name;

	private Optional<String>	last_name	= Optional.empty();
	private Optional<Integer>	user_id		= Optional.empty();

	public static TelegramContact create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramContact.class);
	}

	public String getPhone_number() {

		return phone_number;
	}

	public void setPhone_number(String phone_number) {

		this.phone_number = phone_number;
	}

	public String getFirst_name() {

		return first_name;
	}

	public void setFirst_name(String first_name) {

		this.first_name = first_name;
	}

	public boolean hasLast_name() {

		return this.last_name.isPresent();
	}

	public String getLast_name() throws NoSuchElementException {

		return last_name.get();
	}

	public void setLast_name(String last_name) {

		this.last_name = Optional.of(last_name);
	}

	public boolean hasUser_id() {

		return this.user_id.isPresent();
	}

	public Integer getUser_id() throws NoSuchElementException {

		return user_id.get();
	}

	public void setUser_id(Integer user_id) {

		this.user_id = Optional.of(user_id);
	}

}
