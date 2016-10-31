package exh3y.telebot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.naming.directory.InvalidAttributesException;

import org.json.JSONObject;
import org.junit.Test;

import exh3y.telebot.actions.TelegramActionHandler;
import exh3y.telebot.actions.TelegramResponseHandler;
import exh3y.telebot.exceptions.InvalidApiKeyException;

public class TeleBotTest implements TelegramActionHandler, TelegramResponseHandler {

	@Test
	public void testTeleBotCreation() {

		String apiKey = System.getenv("TelegramApiKey");
		if (apiKey == null) {
			apiKey = "123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11";
		}

		try {
			new TeleBot(apiKey);
		} catch (InvalidApiKeyException e) {
		}

		// Create an invalid bot
		try {
			new TeleBot("123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11");
		} catch (InvalidApiKeyException e) {
		}
	}

	@Test
	public void testCommandRegistration() {

		String apiKey = System.getenv("TelegramApiKey");
		if (apiKey == null) {
			apiKey = "123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11";
		}

		TeleBot bot;
		try {
			bot = new TeleBot(apiKey);
			
			bot.registerCommandAction("/test", this);
			bot.unregisterCommandAction("/test");
			bot.unregisterCommandAction("/anothercommand");
			bot.registerDefaultTextAction(this);
			bot.registerResponseHandler(this);
			bot.unregisterResponseHandler(this);
			bot.registerControllerAction(this);
		} catch (InvalidApiKeyException | InvalidAttributesException e1) {
			assertFalse(true);
		}
	}

	@Test
	public void testInvalidCommandRegistration() {

		String apiKey = System.getenv("TelegramApiKey");
		if (apiKey == null) {
			apiKey = "123456:ABC-DEF1234ghIkl-zyx57W2v1u123ew11";
		}

		TeleBot bot;
		try {
			bot = new TeleBot(apiKey);
			
			bot.registerCommandAction("/test", this);
			bot.registerCommandAction("/test", this);
		} catch (InvalidApiKeyException e1) {
			e1.printStackTrace();
		} catch (InvalidAttributesException e) {
			assertTrue(true);
			return;
		}

		assertFalse(true);
	}

	@Override
	public void onCommandReceive(int chatId, JSONObject message) {

		return;
	}

	@Override
	public void onReceive(JSONObject response) {

		return;
	}

}
