package exh3y.telebot.actions;

import org.json.JSONObject;

import exh3y.telebot.TeleBot;

public abstract class AbstractCommandAction {

	protected TeleBot bot;
	private final String identifier;

	/**
	 * <p>The main method containing the action to execute.</p>
	 * @param responseObject The 'message' part of the response object
	 * @since 0.0.1
	 */
	public abstract void onCommandReceive(JSONObject responseObject);

	/**
	 * <p>Creates a new CommandAction</p>
	 * @param bot The calling bot
	 * @param identifier A unique name to identify this action
	 * @since 0.0.1
	 */
	public AbstractCommandAction(TeleBot bot, String identifier) {

		this.bot = bot;
		this.identifier = identifier;
	}
	
	/**
	 * @return The action's identifier
	 */
	public String getIdentifier() {
		
		return this.identifier;
	}

}
