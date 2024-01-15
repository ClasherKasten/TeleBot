package exh3y.telebot.data.games;

import com.fasterxml.jackson.databind.ObjectMapper;

import exh3y.telebot.data.TelegramMessageEntity;
import exh3y.telebot.data.TelegramPhotoSize;
import exh3y.telebot.util.ObjectMapperFactory;

import kong.unirest.json.JSONObject;

import java.io.IOException;

public class TelegramGame {

    private String title;
    private String description;
    private TelegramPhotoSize[] photo;

    private String text = null;
    private TelegramMessageEntity[] text_entities = null;
    private TelegramAnimation animation = null;

    public static TelegramGame create(JSONObject json) throws IOException {

        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
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

        return text != null;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public boolean hasText_entities() {

        return text_entities != null;
    }

    public TelegramMessageEntity[] getText_entities() {

        return text_entities;
    }

    public void setText_entities(TelegramMessageEntity[] text_entities) {

        this.text_entities = text_entities;
    }

    public boolean hasAnimation() {

        return animation != null;
    }

    public TelegramAnimation getAnimation() {

        return animation;
    }

    public void setAnimation(TelegramAnimation animation) {

        this.animation = animation;
    }
}
