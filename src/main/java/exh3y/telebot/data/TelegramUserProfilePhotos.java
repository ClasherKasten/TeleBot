package exh3y.telebot.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import exh3y.telebot.util.ObjectMapperFactory;

import kong.unirest.json.JSONObject;

import java.io.IOException;

public class TelegramUserProfilePhotos {

    private Integer total_count;
    private TelegramPhotoSize[][] photos;

    public static TelegramUserProfilePhotos create(JSONObject json) throws IOException {

        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
        return mapper.readValue(json.toString(), TelegramUserProfilePhotos.class);
    }

    public Integer getTotal_count() {

        return total_count;
    }

    public void setTotal_count(Integer total_count) {

        this.total_count = total_count;
    }

    public TelegramPhotoSize[][] getPhotos() {

        return photos;
    }

    public void setPhotos(TelegramPhotoSize[][] photos) {

        this.photos = photos;
    }
}
