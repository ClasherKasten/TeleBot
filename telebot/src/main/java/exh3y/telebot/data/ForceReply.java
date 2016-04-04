package exh3y.telebot.data;

import org.json.JSONObject;
import org.json.JSONString;

public class ForceReply implements JSONString {

	public boolean selective;

	/**
	 * Creates a new ForceReply object
	 * 
	 * @param selective
	 * @see <a href="https://core.telegram.org/bots/api#forcereply">https://core
	 *      .telegram.org/bots/api#forcereply</a>
	 */
	public ForceReply(boolean selective) {

		this.selective = selective;
	}

	@Override
	public String toJSONString() {

		JSONObject object = new JSONObject();
		object.put("force_reply", true);

		if (selective) {
			object.put("selective", true);
		}

		return object.toString();
	}

}
