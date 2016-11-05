package exh3y.telebot.data.games;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import exh3y.telebot.data.TelegramPhotoSize;

public class TelegramAnimation {

	private String						file_id;

	private Optional<TelegramPhotoSize>	thumb		= Optional.empty();
	private Optional<String>			file_name	= Optional.empty();
	private Optional<String>			mime_type	= Optional.empty();
	private Optional<Integer>			file_size	= Optional.empty();

	public static TelegramAnimation create(JSONObject json)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramAnimation.class);
	}

	public String getFile_id() {

		return file_id;
	}

	public void setFile_id(String file_id) {

		this.file_id = file_id;
	}

	public boolean hasThumb() {

		return this.thumb.isPresent();
	}

	public TelegramPhotoSize getThumb() throws NoSuchElementException {

		return thumb.get();
	}

	public void setThumb(TelegramPhotoSize thumb) {

		this.thumb = Optional.of(thumb);
	}

	public boolean hasFile_name() {

		return this.file_name.isPresent();
	}

	public String getFile_name() throws NoSuchElementException {

		return file_name.get();
	}

	public void setFile_name(String file_name) {

		this.file_name = Optional.of(file_name);
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
