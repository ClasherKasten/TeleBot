package exh3y.telebot;

import java.util.HashMap;

import javax.naming.directory.InvalidAttributesException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONString;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import exh3y.telebot.actions.TelegramActionHandler;
import exh3y.telebot.data.TelegramMessage;

public class TeleBot extends Thread {

	private final String							endpoint;
	private final String							token;
	private final String							botName;

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

		String botName = "unknown";
		try {
			botName = getMe().getBody().getObject().getJSONObject("result").getString("username");
		} catch (JSONException | UnirestException e) {
			System.out.println("Not able to receive the bot's name: " + e.getMessage());
		}

		this.botName = botName;

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
	 *            The action to register or null to remove the registered action
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
	 * @param parseMode
	 *            The parse mode to use
	 * @param disableWebPagePreview
	 *            Disables the web page preview in the chat
	 * @param disableNotification
	 *            Send the message silently
	 * @param replyToMessageID
	 *            The message id to reply to. '-1' if the message is not a reply
	 * @param replyMarkup
	 *            The keyboard markup to use for replies.
	 * @return The servers response
	 * @throws UnirestException
	 * @since 0.0.1
	 */
	public HttpResponse<JsonNode> sendMessage(Integer chatId, String text, String parseMode,
			boolean disableWebPagePreview, boolean disableNotification, int replyToMessageID,
			JSONString replyMarkup) throws UnirestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("text", text);

		if (parseMode != null) {
			parameters.put("parse_mode", parseMode);
		}

		if (disableWebPagePreview) {
			parameters.put("disable_web_page_preview", true);
		}

		if (disableNotification) {
			parameters.put("disable_notification", true);
		}

		if (replyToMessageID != -1) {
			parameters.put("reply_to_message_id", replyToMessageID);
		}

		if (replyMarkup != null) {
			parameters.put("reply_markup", replyMarkup.toJSONString());
		}

		return Unirest.post(endpoint + token + "/sendMessage").fields(parameters).asJson();
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

		return sendMessage(chatId, text, null, false, false, -1, null);
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
	private HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException {

		return Unirest.post(endpoint + token + "/getUpdates").field("offset", offset).asJson();
	}

	/**
	 * <p>
	 * Requests the getMe method.
	 * </p>
	 * 
	 * @return
	 * @throws UnirestException
	 */
	public HttpResponse<JsonNode> getMe() throws UnirestException {

		return Unirest.post(endpoint + token + "/getMe").asJson();
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

	/**
	 * <p>
	 * Returns the bot's username.
	 * </p>
	 * 
	 * @return
	 */
	public String getBotName() {

		return this.botName;
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
						TelegramMessage message = new TelegramMessage(
								jsonResponse.getJSONObject(i).getJSONObject("message"));
						int chatId = message.getChatId();

						if (message.has("text")) {

							String command[] = message.toCommandArray();
							String cmd = "";
							boolean executeCommand = true;

							if (command[0].contains("@")) {

								String[] commandList = command[0].split("@");
								if (commandList[1].equals(botName)) {
									cmd = commandList[0];
								} else {
									executeCommand = false;
								}

							} else {
								cmd = command[0];
							}

							if (actionConnector.containsKey(cmd)) {
								TelegramActionHandler action = actionConnector.get(cmd);
								action.onCommandReceive(chatId, message);
							} else if (defaultAction != null && executeCommand) {
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
