package exh3y.telebot.data.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains all possible chat types.
 *
 * @since 0.0.6
 */
public enum ETelegramChatType {
    @JsonProperty("private")
    PRIVATE("private"),

    @JsonProperty("group")
    GROUP("group"),

    @JsonProperty("supergroup")
    SUPERGROUP("supergroup"),

    @JsonProperty("channel")
    CHANNEL("channel");

    private String chatTypeString;

    @JsonCreator
    ETelegramChatType(String chatTypeString) {
        this.chatTypeString = chatTypeString;
    }

    public String getChatTypeString() {

        return chatTypeString;
    }

    /**
     * Returns the ETelegramChatType (determined by the content of the type field)
     *
     * @param name
     * @return The ETelegramChatType
     * @since 0.0.6
     */
    public static ETelegramChatType getEnumByName(String name) {

        for (ETelegramChatType singleEnum : ETelegramChatType.values()) {
            if (singleEnum.getChatTypeString().equals(name)) {
                return singleEnum;
            }
        }

        return null;
    }
}
