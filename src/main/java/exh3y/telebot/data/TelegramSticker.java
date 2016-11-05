package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramSticker {

	private String						file_id;
	private Integer						width;
	private Integer						height;

	private Optional<TelegramPhotoSize>	thumb		= Optional.empty();
	private Optional<String>			emoji		= Optional.empty();
	private Optional<Integer>			file_size	= Optional.empty();

	public static TelegramSticker create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramSticker.class);
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

	public boolean hasEmoji() {

		return this.emoji.isPresent();
	}

	/**
	 * @return the emoji
	 */
	public String getEmoji() throws NoSuchElementException {

		return emoji.get();
	}

	/**
	 * @param emoji
	 *            the emoji to set
	 */
	public void setEmoji(String emoji) {

		this.emoji = Optional.of(emoji);
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
