package exh3y.telebot.data;

import exh3y.telebot.util.ObjectMapperFactory;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

public class TelegramMessageEntity {

    private String type;
    private int offset;
    private int length;

    private String url = null;
    private TelegramUser user = null;

    public static TelegramMessageEntity create(JSONObject json) throws IOException {

        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
        return mapper.readValue(json.toString(), TelegramMessageEntity.class);
    }

    /**
     * @return the type
     */
    public String getType() {

        return type;
    }

    /**
     * @param type the type to set
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
     * @param offset the offset to set
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
     * @param length the length to set
     */
    public void setLength(int length) {

        this.length = length;
    }

    public boolean hasUrl() {

        return url != null;
    }

    /**
     * @return the url
     */
    public String getUrl() {

        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {

        this.url = url;
    }

    public boolean hasUser() {

        return user != null;
    }

    /**
     * @return the user
     */
    public TelegramUser getUser() {

        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(TelegramUser user) {

        this.user = user;
    }
}
