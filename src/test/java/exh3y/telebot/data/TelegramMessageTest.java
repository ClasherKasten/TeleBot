package exh3y.telebot.data;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Random;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import exh3y.telebot.data.enums.ETelegramChatType;
import exh3y.telebot.testutil.StringGenerator;

public class TelegramMessageTest {

	private TelegramMessage createTestMessage(JSONObject json) throws JsonParseException, JsonMappingException, JSONException, IOException {

		if (json == null) {
			json = new JSONObject(
					"{\"message_id\":42,\"from\":{\"id\":547885,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\"},\"chat\":{\"id\":1337,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\",\"type\":\"private\"},\"date\":1450006107,\"text\":\"This is a test message.\"}");
		}
		return new TelegramMessage(json);

	}

	@Test
	public void testMessageCreation() {

		JSONObject json = new JSONObject(
				"{\"message_id\":42,\"from\":{\"id\":547885,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\"},\"chat\":{\"id\":1337,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\",\"type\":\"private\"},\"date\":1450006107,\"text\":\"This is a test message.\"}");

		TelegramMessage telemessage;
		try {
			telemessage = createTestMessage(json);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
			assertTrue(false);
			return;
		}

		assertTrue(telemessage.getText().equals("This is a test message."));
		assertTrue(telemessage.getChat().getId() == 1337);
		assertTrue(telemessage.getMessageId() == 42);
		assertTrue(telemessage.getChat().getType().equals(ETelegramChatType.PRIVATE));
	}

	@Test
	public void testMessageToCommandArray() {

		Random rand = new Random();
		StringGenerator stringGenerator = new StringGenerator();

		for (int count = 1; count <= 20; count = count + 5) {
			String[] commandArray = new String[count];

			if (count == 1) {
				count = 0;
			}

			String commandString = "";
			for (int i = 0; i < commandArray.length; i++) {
				commandArray[i] = "str" + stringGenerator.randomString(rand.nextInt(24) + 1);
				commandString += commandArray[i];

				if (i < commandArray.length - 1) {
					commandString += " ";
				}
			}

			System.out.println("Length of tested command: \t" + commandArray.length + " items");
			System.out.println("Total length: \t\t\t" + commandString.length() + " characters");

			for (int i = 0; i < 10; i++) {

				TelegramMessage message;
				try {
					message = createTestMessage(stringGenerator.randomJSONMessage(commandString));
				} catch (JSONException | IOException e) {
					e.printStackTrace();
					assertTrue(false);
					return;
				}

				String[] commands = message.toCommandArray();

				assertTrue(commands.length == commandArray.length);

				for (int j = 0; j < commands.length; j++) {

					assertTrue(commands[j].equals(commandArray[j]));
				}
			}
		}
	}

}
