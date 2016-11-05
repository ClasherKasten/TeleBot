package exh3y.telebot.data.games;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import exh3y.telebot.data.TelegramMessageEntity;
import exh3y.telebot.data.TelegramPhotoSize;

public class TelegramGame {

	private String								title;
	private String								description;
	private TelegramPhotoSize[]					photo;

	private Optional<String>					text			= Optional.empty();
	private Optional<TelegramMessageEntity[]>	text_entities	= Optional.empty();
	private Optional<TelegramAnimation>			animation		= Optional.empty();

	public static TelegramGame create(JSONObject json) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.toString(), TelegramGame.class);
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public TelegramPhotoSize[] getPhoto() {

		return photo;
	}

	public void setPhoto(TelegramPhotoSize[] photo) {

		this.photo = photo;
	}

	public boolean hasText() {

		return this.text.isPresent();
	}

	public String getText() throws NoSuchElementException {

		return text.get();
	}

	public void setText(String text) {

		this.text = Optional.of(text);
	}

	public boolean hasText_entities() {

		return this.text_entities.isPresent();
	}

	public TelegramMessageEntity[] getText_entities() throws NoSuchElementException {

		return text_entities.get();
	}

	public void setText_entities(TelegramMessageEntity[] text_entities) {

		this.text_entities = Optional.of(text_entities);
	}

	public boolean hasAnimation() {

		return this.animation.isPresent();
	}

	public TelegramAnimation getAnimation() throws NoSuchElementException {

		return animation.get();
	}

	public void setAnimation(TelegramAnimation animation) {

		this.animation = Optional.of(animation);
	}

}
