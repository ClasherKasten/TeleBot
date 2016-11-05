package exh3y.telebot.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

public class TelegramVenueTest {

	@Test
	public void testVenueCreation() {

		String venueString = "{\"location\":{\"longitude\":12.01257, \"latitude\":54.12514}, \"title\":\"Some location\", \"address\": \"some street 12\"}";
		JSONObject json = new JSONObject(venueString);

		TelegramVenue venue;
		try {
			venue = TelegramVenue.create(json);
		} catch (IOException e) {
			assertTrue(false);
			return;
		}

		assertEquals(venue.getTitle(), json.getString("title"));
		assertEquals(venue.getAddress(), json.getString("address"));
	}

}
