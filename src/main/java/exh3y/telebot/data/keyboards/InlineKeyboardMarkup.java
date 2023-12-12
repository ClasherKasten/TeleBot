package exh3y.telebot.data.keyboards;

import org.json.JSONArray;
import org.json.JSONObject;

public class InlineKeyboardMarkup implements ReplyMarkup {

    public InlineKeyboardButton[][] keyboard;

    /**
     * Creates a new InlineKeyboardMarkup
     *
     * @param keyboard The buttons to show to the user
     * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">
     *     https://core.telegram.org/bots/api#inlinekeyboardmarkup</a>
     */
    public InlineKeyboardMarkup(InlineKeyboardButton[][] keyboard) {

        this.keyboard = keyboard;
    }

    public InlineKeyboardMarkup(String[][] buttons) {

        InlineKeyboardButton[][] keyboard = new InlineKeyboardButton[buttons.length][];

        for (int i = 0; i < buttons.length; i++) {

            keyboard[i] = new InlineKeyboardButton[buttons[i].length];

            for (int j = 0; j < buttons[i].length; j++) {

                keyboard[i][j] = new InlineKeyboardButton(buttons[i][j]);
            }
        }

        this.keyboard = keyboard;
    }

    @Override
    public String toJSONString() {

        JSONArray keyboard = new JSONArray();
        for (int i = 0; i < this.keyboard.length; i++) {

            JSONArray innerArray = new JSONArray();

            for (int j = 0; j < this.keyboard[i].length; j++) {

                innerArray.put(this.keyboard[i][j]);
            }

            keyboard.put(innerArray);
        }

        JSONObject object = new JSONObject();

        object.put("inline_keyboard", keyboard);

        return object.toString();
    }
}
