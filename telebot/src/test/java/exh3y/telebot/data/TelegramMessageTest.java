package exh3y.telebot.data;

import static org.junit.Assert.*;

import java.util.Random;

import org.json.JSONObject;
import org.junit.Test;

import exh3y.telebot.testutil.StringGenerator;

public class TelegramMessageTest {

	@Test
	public void testMessageCreation() {

		JSONObject json = new JSONObject(
				"{\"message_id\":42,\"from\":{\"id\":547885,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\"},\"chat\":{\"id\":1337,\"first_name\":\"Some\",\"last_name\":\"User\",\"username\":\"testuser\",\"type\":\"private\"},\"date\":1450006107,\"text\":\"This is a test message.\"}");
		TelegramMessage telemessage = new TelegramMessage(json);

		assertTrue(telemessage.getText().equals("This is a test message."));
		assertTrue(telemessage.getChatId() == 1337);

	}

	@Test
	public void testMessageToCommandArray() {

		Random rand = new Random();
		StringGenerator stringGenerator = new StringGenerator();

		String[] commandArray = new String[rand.nextInt(24) + 1];
		String commandString = "";
		for (int i = 0; i < commandArray.length; i++) {
			commandArray[i] = "str" + stringGenerator.randomString(rand.nextInt(24) + 1);
			commandString += commandArray[i];

			if (i < commandArray.length - 1) {
				commandString += " ";
			}
		}

		System.out.println("Length of tested command: \t" + commandArray.length + " items");
		System.out.println("Total length: \t\t\t" + commandString.length() + "");

		System.out.println("Command string: " + commandString);

		TelegramMessage message = new TelegramMessage(stringGenerator.randomJSONMessage(commandString));

		System.out.println(message.toString());

		String[] commands = message.toCommandArray();

		assertTrue(commands.length == commandArray.length);

		for (int i = 0; i < commands.length; i++) {

			assertTrue(commands[i].equals(commandArray[i]));
		}

	}

}
