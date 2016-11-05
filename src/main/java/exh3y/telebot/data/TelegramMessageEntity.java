package exh3y.telebot.data;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

public class TelegramMessageEntity {

	private String					type;
	private int						offset;
	private int						length;

	private Optional<String>		url		= Optional.empty();
	private Optional<TelegramUser>	user	= Optional.empty();

	public static TelegramMessageEntity create(JSONObject json)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramMessageEntity.class);
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * @return the offset
	 */
	public int getOffset() {

		return offset;
	}

	/**
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(int offset) {

		this.offset = offset;
	}

	/**
	 * @return the length
	 */
	public int getLength() {

		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {

		this.length = length;
	}

	public boolean hasUrl() {

		return this.url.isPresent();
	}

	/**
	 * @return the url
	 */
	public String getUrl() throws NoSuchElementException {

		return url.get();
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {

		this.url = Optional.of(url);
	}

	public boolean hasUser() {

		return this.user.isPresent();
	}

	/**
	 * @return the user
	 */
	public TelegramUser getUser() throws NoSuchElementException {

		return user.get();
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(TelegramUser user) {

		this.user = Optional.of(user);
	}

}
