package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramDocument {

	private String				file_id;

	private TelegramPhotoSize	thumb		= null;
	private String				file_name	= null;
	private String				mime_type	= null;
	private Integer				file_size	= null;

	public static TelegramDocument create(JSONObject json)
			throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramDocument.class);
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

	public boolean hasThumb() {

		return thumb != null;
	}

	/**
	 * @return the thumb
	 */
	public TelegramPhotoSize getThumb() {

		return thumb;
	}

	/**
	 * @param thumb
	 *            the thumb to set
	 */
	public void setThumb(TelegramPhotoSize thumb) {

		this.thumb = thumb;
	}

	public boolean hasFile_name() {

		return file_name != null;
	}

	/**
	 * @return the file_name
	 */
	public String getFile_name() {

		return file_name;
	}

	/**
	 * @param file_name
	 *            the file_name to set
	 */
	public void setFile_name(String file_name) {

		this.file_name = file_name;
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

	public boolean has_fileSize() {

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
