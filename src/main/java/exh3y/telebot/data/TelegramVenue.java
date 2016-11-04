package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramVenue {

	private TelegramLocation	location;
	private String				title;
	private String				address;

	private Optional<String>	foursquare_id;

	public static TelegramVenue create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramVenue.class);
	}

	public TelegramLocation getLocation() {

		return location;
	}

	public void setLocation(TelegramLocation location) {

		this.location = location;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public boolean hasFoursquare_id() {

		return this.foursquare_id.isPresent();
	}

	public String getFoursquare_id() throws NoSuchElementException {

		return foursquare_id.get();
	}

	public void setFoursquare_id(String foursquare_id) {

		this.foursquare_id = Optional.of(foursquare_id);
	}

}
