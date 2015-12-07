package exh3y.telebot;

import java.util.HashMap;

import javax.naming.directory.InvalidAttributesException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import exh3y.telebot.actions.TelegramActionHandler;

public class TeleBot extends Thread {

	private final String							endpoint;
	private final String							token;

	private long									pollingIntervall	= 1000;

	private HashMap<String, TelegramActionHandler>	actionConnector;
	private TelegramActionHandler					defaultAction		= null;

	/**
	 * <p>
	 * Creates a new TeleBot
	 * </p>
	 * 
	 * @param endpoint
	 *            The api endpoint, defaults to "https://api.telegram.org/bot"
	 * @param token
	 *            The bot's token
	 * @since 0.0.1
	 */
	public TeleBot(String endpoint, String token) {

		this.endpoint = endpoint;
		this.token = token;
		actionConnector = new HashMap<String, TelegramActionHandler>();
	}

	/**
	 * @param token
	 * @since 0.0.1
	 */
	public TeleBot(String token) {

		this("https://api.telegram.org/bot", token);
	}

	/**
	 * <p>
	 * Registers a new action to be executed on receiving the given command.
	 * </p>
	 * 
	 * @param command
	 *            The command to link to the action
	 * @param action
	 *            The action
	 * @throws InvalidAttributesException
	 * @since 0.0.1
	 */
	public void registerCommandAction(String command, TelegramActionHandler action) throws InvalidAttributesException {

		if (actionConnector.containsKey(command)) {
			throw new InvalidAttributesException("Command already registered!");
		}

		actionConnector.put(command, action);
	}

	/**
	 * <p>
	 * Unregisters a command.
	 * </p>
	 * 
	 * @param command
	 *            The command to delete
	 * @since 0.0.1
	 */
	public void unregisterCommandAction(String command) {

		if (actionConnector.containsKey(command)) {
			actionConnector.remove(command);
		}
	}

	/**
	 * <p>
	 * Registers a action handler to handle all unknown text messages.
	 * </p>
	 * 
	 * @param action
	 *            The action to register
	 * @since 0.0.1
	 */
	public void registerDefaultTextAction(TelegramActionHandler action) {

		defaultAction = action;
	}

	/**
	 * <p>
	 * Sends a message to the given chat.
	 * </p>
	 * 
	 * @param chatId
	 *            The chat's id
	 * @param text
	 *            The message to send
	 * @return The servers response
	 * @throws UnirestException
	 * @since 0.0.1
	 */
	public HttpResponse<JsonNode> sendMessage(Integer chatId, String text) throws UnirestException {

		return Unirest.post(endpoint + token + "/sendMessage").field("chat_id", chatId).field("text", text).asJson();
	}

	/**
	 * <p>
	 * Returns all unprocessed messages.
	 * </p>
	 * 
	 * @param offset
	 * @return
	 * @throws UnirestException
	 * @since 0.0.1
	 */
	public HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException {

		return Unirest.post(endpoint + token + "/getUpdates").field("offset", offset).asJson();
	}

	/**
	 * <p>
	 * Sets the time to wait between update requests.
	 * </p>
	 * 
	 * @param millis
	 *            Milliseconds to wait.
	 */
	public void setPollingIntervall(long millis) {

		this.pollingIntervall = millis;
	}

	@Override
	public void run() {

		int lastUpdateId = 0;
		System.out.println("Listening...");

		HttpResponse<JsonNode> response;
		while (true) {
			try {
				response = getUpdates(lastUpdateId++);

				if (response.getStatus() == 200) {

					JSONArray jsonResponse = response.getBody().getObject().getJSONArray("result");

					if (jsonResponse.isNull(0)) {
						continue;
					} else {
						lastUpdateId = jsonResponse.getJSONObject(jsonResponse.length() - 1).getInt("update_id") + 1;
					}

					for (int i = 0; i < jsonResponse.length(); i++) {

						// Iterate over the messages in the last update
						JSONObject message = jsonResponse.getJSONObject(i).getJSONObject("message");
						int chatId = message.getJSONObject("chat").getInt("id");

						if (message.has("text")) {

							String command[] = message.getString("text").split(" ");

							if (actionConnector.containsKey(command[0])) {
								TelegramActionHandler action = actionConnector.get(command[0]);
								action.onCommandReceive(chatId, message);
							} else if (defaultAction != null) {
								defaultAction.onCommandReceive(chatId, message);
							}
						}

					}
				}

			} catch (UnirestException e) {

				try {
					sleep(this.pollingIntervall);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
