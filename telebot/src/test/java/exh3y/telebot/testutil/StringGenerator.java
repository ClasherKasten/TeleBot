package exh3y.telebot.testutil;

import java.util.Random;

public class StringGenerator {

	public String randomString(int length) {

		Random rand = new Random();
		String output = "";

		for (int i = 0; i < length; i++) {
			char currentChar = (char) rand.nextInt((int) Character.MAX_VALUE);
			output += currentChar;
		}

		return output;
	}

}
