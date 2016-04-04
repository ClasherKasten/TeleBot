package exh3y.telebot.data;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class ReplyKeyboardMarkup implements JSONString {

	public String[][] keyboard;
	public boolean resizeKeyboard;
	public boolean oneTimeKeyboard;
	public boolean selective;
	
	public ReplyKeyboardMarkup(String[][] keyboard, boolean resizeKeyboard, boolean oneTimeKeyboard, boolean selective) {
		
		this.keyboard = keyboard;
		this.resizeKeyboard = resizeKeyboard;
		this.oneTimeKeyboard = oneTimeKeyboard;
		this.selective = selective;
	}
	
	public ReplyKeyboardMarkup(String[][] keyboard) {
		
		this(keyboard, false, false, false);
	}

	@Override
	public String toJSONString() {

		JSONArray keyboard = new JSONArray(this.keyboard);
		JSONObject object = new JSONObject();
		
		object.append("keyboard", keyboard);
		
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
