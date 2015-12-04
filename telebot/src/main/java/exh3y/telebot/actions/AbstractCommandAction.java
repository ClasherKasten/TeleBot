package exh3y.telebot.actions;

import org.json.JSONObject;

import exh3y.telebot.TeleBot;

public abstract class AbstractCommandAction {

	protected TeleBot bot;
	private String identifier;

	public abstract void onCommandReceive(JSONObject responseObject);

	
	public AbstractCommandAction(TeleBot bot, String identifier) {

		this.bot = bot;
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		
		return this.identifier;
	}

}
