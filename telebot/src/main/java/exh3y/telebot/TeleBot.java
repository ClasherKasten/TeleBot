package exh3y.telebot;

import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.directory.InvalidAttributesException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import exh3y.telebot.actions.TelegramActionHandler;
import exh3y.telebot.actions.TelegramResponseHandler;
import exh3y.telebot.data.TelegramMessage;
import exh3y.telebot.data.keyboards.InlineKeyboardMarkup;
import exh3y.telebot.data.keyboards.ReplyMarkup;
import exh3y.telebot.exceptions.InvalidRequestException;

public class TeleBot extends Thread {

	private final String							endpoint;
	private final String							token;
	private final String							botName;

	private long									pollingIntervall	= 1000;

	private HashMap<String, TelegramActionHandler>	actionConnector;
	private TelegramActionHandler					defaultAction		= null;
	private TelegramActionHandler					controllerAction	= null;

	private ArrayList<TelegramResponseHandler>		responseHandlers;

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

		String botName = null;
		try {
			botName = getMe().getBody().getObject().getJSONObject("result").getString("username");
		} catch (JSONException | UnirestException e) {
			System.out.println("Not able to receive the bot's name: " + e.getMessage());
		}

		this.botName = botName;

		actionConnector = new HashMap<String, TelegramActionHandler>();
		responseHandlers = new ArrayList<>();
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
	 * Registers a new handler to get notified about new responses.
	 * 
	 * @param handler
	 *            The handler to register
	 * @since 0.0.5
	 */
	public void registerResponseHandler(TelegramResponseHandler handler) {

		responseHandlers.add(handler);
	}

	/**
	 * Unregisters the given handler.
	 * 
	 * @param handler
	 *            The handler to remove from registered handlers
	 * @since 0.0.5
	 */
	public void unregisterResponseHandler(TelegramResponseHandler handler) {

		responseHandlers.remove(handler);
	}

	/**
	 * Registers a single action to be executed on every received message.
	 * 
	 * @param handler
	 *            The handler to register
	 * @since 0.0.5
	 */
	public void registerControllerAction(TelegramActionHandler handler) {

		controllerAction = handler;
	}

	private HttpResponse<JsonNode> sendRawRequest(String method,
			HashMap<String, Object> parameters) throws UnirestException, InvalidRequestException {

		HttpResponse<JsonNode> response = Unirest.post(endpoint + token + "/" + method).fields(parameters).asJson();
		JSONObject jsonResponse = new JSONObject(response.getBody().toString());
		if (!jsonResponse.getBoolean("ok")) {
			throw new InvalidRequestException(jsonResponse.optString("description"));
		}
		return response;
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
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 *             Thrown if the request was not successful
	 * @since 0.0.4
	 */
	public HttpResponse<JsonNode> sendMessage(int chatId, String text, String parseMode, boolean disableWebPagePreview,
			boolean disableNotification, int replyToMessageID,
			ReplyMarkup replyMarkup) throws UnirestException, InvalidRequestException {

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

		return sendRawRequest("sendMessage", parameters);
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
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 *             Thrown if the request was not successful
	 * @since 0.0.1
	 */
	public HttpResponse<JsonNode> sendMessage(int chatId,
			String text) throws UnirestException, InvalidRequestException {

		return sendMessage(chatId, text, null, false, false, -1, null);
	}

	/**
	 * Forwards the given message to a chat.
	 * 
	 * @param chatId
	 *            The chat to forward the message to
	 * @param fromChatId
	 *            The chat the message was sent into
	 * @param disableNotification
	 * @param messageId
	 *            The message to forward
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 *             Thrown if the request was not successful
	 * @since 0.0.4
	 * @see <a href="https://core.telegram.org/bots/api#forwardmessage">https://
	 *      core.telegram.org/bots/api#forwardmessage</a>
	 */
	public HttpResponse<JsonNode> forwardMessage(int chatId, int fromChatId, boolean disableNotification,
			int messageId) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("from_chat_id", fromChatId);
		parameters.put("message_id", messageId);

		if (disableNotification) {
			parameters.put("disable_notification", true);
		}

		return sendRawRequest("forwardMessage", parameters);

	}

	/**
	 * Changes the text of the given message
	 * 
	 * @param chatId
	 *            The chat the message was sent in
	 * @param messageId
	 *            The id of the message to edit
	 * @param text
	 *            The new text
	 * @param parseMode
	 * @param disableWebPagePreview
	 * @param replyMarkup
	 * @return The sent message
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 *             Thrown if the request was not successful
	 */
	public HttpResponse<JsonNode> editMessageText(int chatId, int messageId, String text, String parseMode,
			boolean disableWebPagePreview,
			InlineKeyboardMarkup replyMarkup) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("message_id", messageId);
		parameters.put("text", text);

		if (parseMode != null) {
			parameters.put("parse_mode", parseMode);
		}

		if (disableWebPagePreview) {
			parameters.put("disable_web_page_preview", true);
		}

		if (replyMarkup != null) {
			parameters.put("reply_markup", replyMarkup.toJSONString());
		}

		return sendRawRequest("editMessageText", parameters);
	}

	/**
	 * Edits a message's caption
	 * 
	 * @param chatId
	 *            The chat the message was sent in
	 * @param messageId
	 *            The message's id
	 * @param caption
	 *            The new caption
	 * @param replyMarkup
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 * @since 0.0.5
	 * @see <a href="https://core.telegram.org/bots/api#editmessagecaption">
	 *      https://core.telegram.org/bots/api#editmessagecaption</a>
	 */
	public HttpResponse<JsonNode> editMessageCaption(int chatId, int messageId, String caption,
			InlineKeyboardMarkup replyMarkup) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("message_id", messageId);

		if (caption != null) {
			parameters.put("caption", caption);
		}

		if (replyMarkup != null) {
			parameters.put("reply_markup", replyMarkup);
		}

		return sendRawRequest("editMessageCaption", parameters);

	}

	/**
	 * Edits the reply markup of the given message
	 * 
	 * @param chatId
	 *            The chat's id
	 * @param messageId
	 *            The message's id
	 * @param replyMarkup
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 * @since 0.0.5
	 * @see <a href="https://core.telegram.org/bots/api#editmessagereplymarkup">
	 *      https://core.telegram.org/bots/api#editmessagereplymarkup</a>
	 */
	public HttpResponse<JsonNode> editMessageReplyMarkup(int chatId, int messageId,
			InlineKeyboardMarkup replyMarkup) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("message_id", messageId);

		if (replyMarkup != null) {
			parameters.put("reply_markup", replyMarkup);
		}

		return sendRawRequest("editMessageReplyMarkup", parameters);
	}

	/**
	 * Sends a given location to a chat
	 * 
	 * @param chatId
	 *            The chat to send the message to
	 * @param latitude
	 * @param longitude
	 * @param disableNotification
	 * @param replyToMessageId
	 * @param replyMarkup
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 *             Thrown if the request was not successful
	 * @since 0.0.4
	 * @see <a href="https://core.telegram.org/bots/api#sendlocation">https://
	 *      core.telegram.org/bots/api#sendlocation</a>
	 */
	public HttpResponse<JsonNode> sendLocation(int chatId, float latitude, float longitude, boolean disableNotification,
			int replyToMessageId, ReplyMarkup replyMarkup) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("latitude", latitude);
		parameters.put("longitude", longitude);

		if (disableNotification) {
			parameters.put("disable_notification", true);
		}

		if (replyToMessageId != -1) {
			parameters.put("reply_to_message_id", replyToMessageId);
		}

		if (replyMarkup != null) {
			parameters.put("reply_markup", replyMarkup.toJSONString());
		}

		return sendRawRequest("sendLocation", parameters);

	}

	/**
	 * Sends a chat action to the given chat.
	 * 
	 * @param chatId
	 *            The chat to send the message to
	 * @param action
	 *            The action to send
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 *             Thrown if the request was not successful
	 * @since 0.0.4
	 * @see <a href="https://core.telegram.org/bots/api#sendchataction">https://
	 *      core.telegram.org/bots/api#sendchataction</a>
	 */
	public HttpResponse<JsonNode> sendChatAction(int chatId,
			String action) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("action", action);

		return sendRawRequest("sendChatAction", parameters);

	}

	/**
	 * Sends a contact to the given chat
	 * 
	 * @param chatId
	 *            The chat to send the message to
	 * @param phoneNumber
	 *            The contact's phone number
	 * @param firstName
	 *            The contact's first name
	 * @param lastName
	 *            The contact's last name
	 * @param disableNotification
	 * @param replyToMessageId
	 * @param replyMarkup
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 * @since 0.0.5
	 */
	public HttpResponse<JsonNode> sendSontact(int chatId, String phoneNumber, String firstName, String lastName,
			boolean disableNotification, int replyToMessageId,
			ReplyMarkup replyMarkup) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("phone_number", phoneNumber);
		parameters.put("first_name", firstName);

		if (lastName != null) {
			parameters.put("last_name", lastName);
		}

		if (disableNotification) {
			parameters.put("disable_notification", true);
		}

		if (replyToMessageId != -1) {
			parameters.put("reply_to_message_id", replyToMessageId);
		}

		if (replyMarkup != null) {
			parameters.put("reply_markup", replyMarkup);
		}

		return sendRawRequest("sendContact", parameters);

	}

	/**
	 * Sends a venue to the given chat.
	 * 
	 * @param chatId
	 *            The chat to send the venue to
	 * @param latitude
	 *            The venue's latitude
	 * @param longitude
	 *            The venue's longitude
	 * @param title
	 *            The venue's title
	 * @param address
	 *            The venue's address
	 * @param foursquareId
	 *            The foursquare_id of the venue
	 * @param disableNotification
	 * @param replyToMessageId
	 * @param replyMarkup
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 * @since 0.0.5
	 * @see <a href="https://core.telegram.org/bots/api#sendvenue">https://core.
	 *      telegram.org/bots/api#sendvenue</a>
	 */
	public HttpResponse<JsonNode> sendVenue(int chatId, float latitude, float longitude, String title, String address,
			String foursquareId, boolean disableNotification, int replyToMessageId,
			ReplyMarkup replyMarkup) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("latitude", latitude);
		parameters.put("longitude", longitude);
		parameters.put("title", title);
		parameters.put("address", address);

		if (foursquareId != null) {
			parameters.put("foursquare_id", foursquareId);
		}

		if (disableNotification) {
			parameters.put("disable_notification", true);
		}

		if (replyToMessageId != -1) {
			parameters.put("reply_to_message_id", replyToMessageId);
		}

		if (replyMarkup != null) {
			parameters.put("reply_markup", replyMarkup);
		}

		return sendRawRequest("sendVenue", parameters);
	}

	/**
	 * Kicks a user from a group.
	 * 
	 * @param chatId
	 *            The chat's id
	 * @param userId
	 *            The user's id
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 * @since 0.0.5
	 * @see <a href="https://core.telegram.org/bots/api#kickchatmember">https://
	 *      core.telegram.org/bots/api#kickchatmember</a>
	 */
	public HttpResponse<JsonNode> kickChatMember(int chatId,
			int userId) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("user_id", userId);

		return sendRawRequest("kickChatMember", parameters);
	}

	/**
	 * Unbans a previously kicked user in a supergroup.
	 * 
	 * @param chatId
	 *            The chat's id
	 * @param userId
	 *            The user's id
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 * @since 0.0.5
	 * @see <a href="https://core.telegram.org/bots/api#unbanchatmember">https:/
	 *      /core.telegram.org/bots/api#unbanchatmember</a>
	 */
	public HttpResponse<JsonNode> unbanChatMember(int chatId,
			int userId) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("chat_id", chatId);
		parameters.put("user_id", userId);

		return sendRawRequest("unbanChatMember", parameters);
	}

	/**
	 * Sends an answer to a callback query
	 * 
	 * @param callbackQueryId
	 *            The query to answer
	 * @param text
	 *            The text to show
	 * @param showAlert
	 *            Show an alert instead of a notification
	 * @return The server's response
	 * @throws UnirestException
	 * @throws InvalidRequestException
	 * @since 0.0.5
	 * @see <a href="https://core.telegram.org/bots/api#answercallbackquery">
	 *      https://core.telegram.org/bots/api#answercallbackquery</a>
	 */
	public HttpResponse<JsonNode> answerCallbackQuery(String callbackQueryId, String text,
			boolean showAlert) throws UnirestException, InvalidRequestException {

		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("callback_query_id", callbackQueryId);

		if (text != null) {
			parameters.put("text", text);
		}

		if (showAlert) {
			parameters.put("show_alert", showAlert);
		}

		return sendRawRequest("answerCallbackQuery", parameters);

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
						JSONObject responseObject = jsonResponse.getJSONObject(i);
						controllerAction.onCommandReceive(-1, responseObject);

						if (responseObject.has("message")) {
							TelegramMessage message = new TelegramMessage(responseObject.getJSONObject("message"));
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
						} else {

							for (TelegramResponseHandler handler : responseHandlers) {

								handler.onReceive(responseObject);
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
