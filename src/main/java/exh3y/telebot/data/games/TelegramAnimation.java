package exh3y.telebot.data.games;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import exh3y.telebot.data.TelegramPhotoSize;

public class TelegramAnimation {

	private String				file_id;

	private TelegramPhotoSize	thumb		= null;
	private String				file_name	= null;
	private String				mime_type	= null;
	private Integer				file_size	= null;

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

		return thumb != null;
	}

	public TelegramPhotoSize getThumb() {

		return thumb;
	}

	public void setThumb(TelegramPhotoSize thumb) {

		this.thumb = thumb;
	}

	public boolean hasFile_name() {

		return file_name != null;
	}

	public String getFile_name() {

		return file_name;
	}

	public void setFile_name(String file_name) {

		this.file_name = file_name;
	}

	public boolean hasMime_type() {

		return mime_type != null;
	}

	public String getMime_type() {

		return mime_type;
	}

	public void setMime_type(String mime_type) {

		this.mime_type = mime_type;
	}

	public boolean hasFile_size() {

		return file_size != null;
	}

	public Integer getFile_size() throws NoSuchElementException {

		return file_size;
	}

	public void setFile_size(Integer file_size) {

		this.file_size = file_size;
	}

}
