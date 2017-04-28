package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramVoice {

	private String	file_id;
	private Integer	duration;

	private String	mime_type	= null;
	private Integer	file_size	= null;

	public static TelegramVoice create(JSONObject json) throws IOException {

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

		return mime_type != null;
	}

	/**
	 * @return the mime_type
	 */
	public String getMime_type() {

		return mime_type;
	}

	/**
	 * @param mime_type
	 *            the mime_type to set
	 */
	public void setMime_type(String mime_type) {

		this.mime_type = mime_type;
	}

	public boolean hasFile_size() {

		return file_size != null;
	}

	/**
	 * @return the file_size
	 */
	public Integer getFile_size() {

		return file_size;
	}

	/**
	 * @param file_size
	 *            the file_size to set
	 */
	public void setFile_size(Integer file_size) {

		this.file_size = file_size;
	}

}
