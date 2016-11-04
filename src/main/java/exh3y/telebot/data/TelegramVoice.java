package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramVoice {

	private String				file_id;
	private Integer				duration;

	private Optional<String>	mime_type;
	private Optional<Integer>	file_size;

	public static TelegramVoice create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramVoice.class);
	}

	public String getFile_id() {

		return file_id;
	}

	public void setFile_id(String file_id) {

		this.file_id = file_id;
	}

	public Integer getDuration() {

		return duration;
	}

	public void setDuration(Integer duration) {

		this.duration = duration;
	}

	public boolean hasMime_type() {

		return this.mime_type.isPresent();
	}

	public String getMime_type() throws NoSuchElementException {

		return mime_type.get();
	}

	public void setMime_type(String mime_type) {

		this.mime_type = Optional.of(mime_type);
	}

	public boolean hasFile_size() {

		return this.file_size.isPresent();
	}

	public Integer getFile_size() throws NoSuchElementException {

		return file_size.get();
	}

	public void setFile_size(Integer file_size) {

		this.file_size = Optional.of(file_size);
	}

}
