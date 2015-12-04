package exh3y.telebot;

import java.util.HashMap;

import javax.naming.directory.InvalidAttributesException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import exh3y.telebot.actions.AbstractCommandAction;

public class TeleBot extends Thread {

	private final String							endpoint;
	private final String							token;
	private HashMap<String, AbstractCommandAction>	actionConnector;

	public TeleBot(String endpoint, String token) {

		this.endpoint = endpoint;
		this.token = token;
		actionConnector = new HashMap<String, AbstractCommandAction>();
	}

	public TeleBot(String token) {

		this("https://api.telegram.org/bot", token);
	}

	public void registerCommandAction(String command, AbstractCommandAction action) throws InvalidAttributesException {

		if (actionConnector.containsKey(command)) {
			throw new InvalidAttributesException("Command already registered!");
		}

		actionConnector.put(command, action);
	}

	public void unregisterCommandAction(String command) {

		if (actionConnector.containsKey(command)) {

			actionConnector.remove(command);
		}
	}

	public HttpResponse<JsonNode> sendMessage(Integer chatId, String text) throws UnirestException {

		return Unirest.post(endpoint + token + "/sendMessage").field("chat_id", chatId).field("text", text).asJson();
	}

	public HttpResponse<JsonNode> getUpdates(Integer offset) throws UnirestException {

		return Unirest.post(endpoint + token + "/getUpdates").field("offset", offset).asJson();
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

						// Iterate through messages in the last update
						JSONObject message = jsonResponse.getJSONObject(i).getJSONObject("message");

						if (message.has("text")) {

							String command[] = message.getString("text").split(" ");

							if (actionConnector.containsKey(command[0])) {
								AbstractCommandAction action = actionConnector.get(command[0]);
								action.onCommandReceive(message);
							}
						}

					}
				}

			} catch (UnirestException e) {

				try {
					sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
