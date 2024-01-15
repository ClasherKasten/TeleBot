package exh3y.telebot.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import exh3y.telebot.util.ObjectMapperFactory;

import kong.unirest.json.JSONObject;

import java.io.IOException;

public class TelegramLocation {

    private Float longitude;
    private Float latitude;

    public static TelegramLocation create(JSONObject json) throws IOException {

        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
        return mapper.readValue(json.toString(), TelegramLocation.class);
    }

    public Float getLongitude() {

        return longitude;
    }

    public void setLongitude(Float longitude) {

        this.longitude = longitude;
    }

    public Float getLatitude() {

        return latitude;
    }

    public void setLatitude(Float latitude) {

        this.latitude = latitude;
    }
}
