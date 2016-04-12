package exh3y.telebot;

import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;

import exh3y.telebot.actions.TelegramActionHandler;
import exh3y.telebot.actions.TelegramMessageHandler;
import exh3y.telebot.data.TelegramMessage;

public class TeleBotTest implements TelegramMessageHandler {

	@Test
	public void testTeleBotCreation() {

		TeleBot bot = new TeleBot("123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11");
		try {
			bot.registerCommandAction("/test", this);
			bot.unregisterCommandAction("/test");
			bot.registerDefaultTextAction(this);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Override
	public void onCommandReceive(int chatId, TelegramMessage message) {

		return;
	}

	@Override
	public void onCommandReceive(JSONObject response) {

		// TODO Auto-generated method stub
		
	}

}
