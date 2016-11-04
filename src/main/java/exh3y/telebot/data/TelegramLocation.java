package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramLocation {

	private Float	longitude;
	private Float	latitude;

	public static TelegramLocation create(JSONObject json)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramLocation.class);
	}

	public Float getLongitude() {

		return longitude;
	}

	public void setLongitude(Float longitude) {

		this.longitude = longitude;
	}

	public Float getLatitude() {

		return latitude;
	}

	public void setLatitude(Float latitude) {

		this.latitude = latitude;
	}

}
