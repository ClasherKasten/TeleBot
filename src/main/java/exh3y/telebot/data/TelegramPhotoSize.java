package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramPhotoSize {

	private String	file_id;
	private Integer	width;
	private Integer	height;

	private Integer	file_size	= null;

	public static TelegramPhotoSize create(JSONObject json)
			throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramPhotoSize.class);
	}

	/**
	 * @return the file_id
	 */
	public String getFile_id() {

		return file_id;
	}

	/**
	 * @param file_id
	 *            the file_id to set
	 */
	public void setFile_id(String file_id) {

		this.file_id = file_id;
	}

	/**
	 * @return the width
	 */
	public Integer getWidth() {

		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(Integer width) {

		this.width = width;
	}

	/**
	 * @return the height
	 */
	public Integer getHeight() {

		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(Integer height) {

		this.height = height;
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
