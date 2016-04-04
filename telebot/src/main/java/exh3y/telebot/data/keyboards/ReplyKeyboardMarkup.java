package exh3y.telebot.data.keyboards;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class ReplyKeyboardMarkup implements JSONString {

	public String[][]	keyboard;
	public boolean		resizeKeyboard;
	public boolean		oneTimeKeyboard;
	public boolean		selective;

	/**
	 * Creates a new ReplyKeyboardMarkup
	 * 
	 * @param keyboard
	 *            The buttons to show (in table format)
	 * @param resizeKeyboard
	 * @param oneTimeKeyboard
	 * @param selective
	 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">
	 *      https://core.telegram.org/bots/api#replykeyboardmarkup</a>
	 * @since 0.0.4
	 */
	public ReplyKeyboardMarkup(String[][] keyboard, boolean resizeKeyboard, boolean oneTimeKeyboard,
			boolean selective) {

		this.keyboard = keyboard;
		this.resizeKeyboard = resizeKeyboard;
		this.oneTimeKeyboard = oneTimeKeyboard;
		this.selective = selective;
	}

	/**
	 * Creates a new ReplyKeyboardMarkup with default settings.
	 * 
	 * @param keyboard
	 *            The buttons to show (in table format)
	 * @since 0.0.4
	 */
	public ReplyKeyboardMarkup(String[][] keyboard) {

		this(keyboard, false, false, false);
	}

	@Override
	public String toJSONString() {

		JSONArray keyboard = new JSONArray(this.keyboard);
		JSONObject object = new JSONObject();

		object.put("keyboard", keyboard);

		if (resizeKeyboard) {
			object.put("resize_keyboard", true);
		}

		if (oneTimeKeyboard) {
			object.put("one_time_keyboard", true);
		}

		if (selective) {
			object.put("selective", true);
		}

		return object.toString();
	}

}
