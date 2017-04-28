package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramVideo {

	private String				file_id;
	private Integer				width;
	private Integer				height;
	private Integer				duration;

	private TelegramPhotoSize	thumb		= null;
	private String				mime_type	= null;
	private Integer				file_size	= null;

	public static TelegramVideo create(JSONObject json) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramVideo.class);
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

	/**
	 * @return the duration
	 */
	public Integer getDuration() {

		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Integer duration) {

		this.duration = duration;
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
