package exh3y.telebot.data.keyboards;

import static org.junit.Assert.*;

import exh3y.telebot.testutil.StringGenerator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Random;

public class ReplyKeyboardMarkupTest {

    @Test
    public void testKeyboardCreation() {

        StringGenerator gen = new StringGenerator();
        Random rand = new Random();

        String[][] keyboard = new String[rand.nextInt(10) + 1][rand.nextInt(10) + 1];

        for (int i = 0; i < keyboard.length; i++) {

            for (int j = 0; j < keyboard[i].length; j++) {

                keyboard[i][j] = gen.randomString(rand.nextInt(20) + 1, true);
            }
        }

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(keyboard);

        assertTrue(markup.keyboard.equals(keyboard));
        assertTrue(markup.oneTimeKeyboard == false);
    }

    @Test
    public void testToJSONString() {

        for (int count = 0; count < 10; count++) {

            StringGenerator gen = new StringGenerator();
            Random rand = new Random();

            String[][] keyboard = new String[rand.nextInt(10) + 1][rand.nextInt(10) + 1];

            for (int i = 0; i < keyboard.length; i++) {

                for (int j = 0; j < keyboard[i].length; j++) {

                    keyboard[i][j] = gen.randomString(rand.nextInt(20) + 1, true);
                }
            }

            boolean[][] testValues = {
                {true, false, false}, {false, true, false}, {false, false, true}
            };

            for (int i = 0; i < testValues.length; i++) {
                ReplyKeyboardMarkup markup =
                        new ReplyKeyboardMarkup(
                                keyboard, testValues[i][0], testValues[i][1], testValues[i][2]);

                JSONObject object = new JSONObject(markup.toJSONString());

                JSONArray objectArray = object.getJSONArray("keyboard");
                JSONArray actualArray = new JSONArray(keyboard);

                assertTrue(objectArray.toString().equals(actualArray.toString()));
            }
        }
    }
}
