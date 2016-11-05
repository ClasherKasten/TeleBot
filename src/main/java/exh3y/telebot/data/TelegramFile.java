package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramFile {

	private String				file_id;

	private Optional<Integer>	file_size;
	private Optional<String>	file_path;

	public static TelegramFile create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramFile.class);
	}

	public String getFile_id() {

		return file_id;
	}

	public void setFile_id(String file_id) {

		this.file_id = file_id;
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

	public boolean hasFile_path() {

		return this.file_path.isPresent();
	}

	public String getFile_path() throws NoSuchElementException {

		return file_path.get();
	}

	public void setFile_path(String file_path) {

		this.file_path = Optional.of(file_path);
	}

}
