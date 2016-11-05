package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramAudio {

	private String				file_id;
	private Integer				duration;

	private Optional<String>	performer	= Optional.empty();
	private Optional<String>	title		= Optional.empty();
	private Optional<String>	mime_type	= Optional.empty();
	private Optional<Integer>	file_size	= Optional.empty();

	public static TelegramAudio create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramAudio.class);
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

	public boolean hasPerformer() {

		return this.performer.isPresent();
	}

	/**
	 * @return the performer
	 */
	public String getPerformer() throws NoSuchElementException {

		return performer.get();
	}

	/**
	 * @param performer
	 *            the performer to set
	 */
	public void setPerformer(String performer) {

		this.performer = Optional.of(performer);
	}

	public boolean hasTitle() {

		return this.title.isPresent();
	}

	/**
	 * @return the title
	 */
	public String getTitle() throws NoSuchElementException {

		return title.get();
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {

		this.title = Optional.of(title);
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
