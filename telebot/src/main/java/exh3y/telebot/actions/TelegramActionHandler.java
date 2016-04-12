package exh3y.telebot.actions;

import org.json.JSONObject;

@Deprecated
public interface TelegramActionHandler extends TelegramCommonHandler {
	
	void onCommandReceive(int chatId, JSONObject message);

}
