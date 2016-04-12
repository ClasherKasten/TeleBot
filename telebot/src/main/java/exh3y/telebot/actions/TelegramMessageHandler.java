package exh3y.telebot.actions;

import exh3y.telebot.data.TelegramMessage;

public interface TelegramMessageHandler extends TelegramCommonHandler {
	
	void onCommandReceive(int chatId, TelegramMessage message);

}
