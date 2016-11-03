package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramDocument {

	private String						file_id;

	private Optional<TelegramPhotoSize>	thumb;
	private Optional<String>			file_name;
	private Optional<String>			mime_type;
	private Optional<Integer>			file_size;

	public static TelegramDocument create(JSONObject json)
			throws JsonParseException, JsonMappingException, IOException {

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

		return this.thumb.isPresent();
	}

	/**
	 * @return the thumb
	 */
	public TelegramPhotoSize getThumb() throws NoSuchElementException {

		return thumb.get();
	}

	/**
	 * @param thumb
	 *            the thumb to set
	 */
	public void setThumb(TelegramPhotoSize thumb) {

		this.thumb = Optional.of(thumb);
	}

	public boolean hasFile_name() {

		return this.file_name.isPresent();
	}

	/**
	 * @return the file_name
	 */
	public String getFile_name() throws NoSuchElementException {

		return file_name.get();
	}

	/**
	 * @param file_name
	 *            the file_name to set
	 */
	public void setFile_name(String file_name) {

		this.file_name = Optional.of(file_name);
	}

	public boolean hasMime_type() {

		return this.mime_type.isPresent();
	}

	/**
	 * @return the mime_type
	 */
	public String getMime_type() throws NoSuchElementException {

		return mime_type.get();
	}

	/**
	 * @param mime_type
	 *            the mime_type to set
	 */
	public void setMime_type(String mime_type) {

		this.mime_type = Optional.of(mime_type);
	}

	public boolean hasFile_size() {

		return this.file_size.isPresent();
	}

	/**
	 * @return the file_size
	 */
	public Integer getFile_size() throws NoSuchElementException {

		return file_size.get();
	}

	/**
	 * @param file_size
	 *            the file_size to set
	 */
	public void setFile_size(Integer file_size) {

		this.file_size = Optional.of(file_size);
	}

}
