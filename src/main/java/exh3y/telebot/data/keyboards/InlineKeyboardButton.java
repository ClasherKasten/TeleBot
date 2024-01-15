package exh3y.telebot.data.keyboards;

import kong.unirest.json.JSONObject;
import kong.unirest.json.JSONString;

public class InlineKeyboardButton implements JSONString {

    private String text;
    private String url;
    private String callbackData;
    private String switchInlineQuery;

    /**
     * Creates a new button for use in an InlineKeyboardMarkup
     *
     * @param text The text to show
     * @param url
     * @param callbackData
     * @param switchInlineQuery
     * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardbutton">
     *     https://core.telegram.org/bots/api#inlinekeyboardbutton</a>
     */
    public InlineKeyboardButton(
            String text, String url, String callbackData, String switchInlineQuery) {
        this.setText(text);
        this.setUrl(url);
        this.setCallbackData(callbackData);
        this.setSwitchInlineQuery(switchInlineQuery);
    }

    public InlineKeyboardButton(String text) {
        this(text, null, text, null);
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public String getCallbackData() {

        return callbackData;
    }

    public void setCallbackData(String callbackData) {

        this.callbackData = callbackData;
    }

    public String getSwitchInlineQuery() {

        return switchInlineQuery;
    }

    public void setSwitchInlineQuery(String switchInlineQuery) {

        this.switchInlineQuery = switchInlineQuery;
    }

    @Override
    public String toJSONString() {

        JSONObject object = new JSONObject();
        object.put("text", text);

        if (url != null) {
            object.put("url", url);
        }

        if (callbackData != null) {
            object.put("callback_data", callbackData);
        }

        if (switchInlineQuery != null) {
            object.put("switch_inline_query", switchInlineQuery);
        }

        return object.toString();
    }
}
