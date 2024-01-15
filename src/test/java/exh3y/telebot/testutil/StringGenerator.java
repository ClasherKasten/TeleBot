package exh3y.telebot.testutil;

import kong.unirest.json.JSONObject;

import java.util.Random;

public class StringGenerator {

    private static final char[] symbols;

    static {
        StringBuilder stringBuilder = new StringBuilder();

        for (char character = '0'; character <= '9'; ++character) stringBuilder.append(character);

        for (char character = 'a'; character <= 'z'; ++character) stringBuilder.append(character);

        for (char character = 'A'; character <= 'Z'; ++character) stringBuilder.append(character);

        symbols = stringBuilder.toString().toCharArray();
    }

    public String randomString(int length, boolean generateSpaces) {

        Random rand = new Random();
        String output = "";

        for (int i = 0; i < length; i++) {
            char currentChar = symbols[rand.nextInt(symbols.length)];
            output += currentChar;
        }

        return output;
    }

    public String randomString(int length) {

        return randomString(length, false);
    }

    public JSONObject randomJSONMessage(String text) {

        Random rand = new Random();

        int messageId = rand.nextInt(500000) + 1;
        int senderId = rand.nextInt(500000) + 1;
        int chatId = rand.nextInt(500000) + 1;

        String firstName = randomString(rand.nextInt(20) + 1);
        String lastName = randomString(rand.nextInt(20) + 1);
        String userName = randomString(rand.nextInt(20) + 1);

        long unixTime = System.currentTimeMillis() / 1000L;

        if (text == null) {

            text = randomString(rand.nextInt(40) + 1, true);
        }

        return new JSONObject(
                "{\"message_id\":"
                        + messageId
                        + ",\"from\":{\"id\":"
                        + senderId
                        + ",\"first_name\":\""
                        + firstName
                        + "\",\"last_name\":\""
                        + lastName
                        + "\",\"username\":\""
                        + userName
                        + "\"},\"chat\":{\"id\":"
                        + chatId
                        + ",\"first_name\":\""
                        + firstName
                        + "\",\"last_name\":\""
                        + lastName
                        + "\",\"username\":\""
                        + userName
                        + "\",\"type\":\"private\"},\"date\":"
                        + unixTime
                        + ",\"text\":\""
                        + text
                        + "\"}");
    }
}
