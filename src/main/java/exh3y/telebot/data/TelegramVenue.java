package exh3y.telebot.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import exh3y.telebot.util.ObjectMapperFactory;

import kong.unirest.json.JSONObject;

import java.io.IOException;

public class TelegramVenue {

    private TelegramLocation location;
    private String title;
    private String address;

    private String foursquare_id = null;

    public static TelegramVenue create(JSONObject json) throws IOException {

        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
        return mapper.readValue(json.toString(), TelegramVenue.class);
    }

    public TelegramLocation getLocation() {

        return location;
    }

    public void setLocation(TelegramLocation location) {

        this.location = location;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public boolean hasFoursquare_id() {

        return foursquare_id != null;
    }

    /**
     * @return the foursquare_id
     */
    public String getFoursquare_id() {

        return foursquare_id;
    }

    /**
     * @param foursquare_id the foursquare_id to set
     */
    public void setFoursquare_id(String foursquare_id) {

        this.foursquare_id = foursquare_id;
    }
}
