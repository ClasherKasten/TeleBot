package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramFile {

	private String	file_id;

	private Integer	file_size	= null;
	private String	file_path	= "";

	public static TelegramFile create(JSONObject json) throws IOException {

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

	public boolean hasFile_path() {

		return file_path != null;
	}

	/**
	 * @return the file_path
	 */
	public String getFile_path() {

		return file_path;
	}

	/**
	 * @param file_path
	 *            the file_path to set
	 */
	public void setFile_path(String file_path) {

		this.file_path = file_path;
	}

}
