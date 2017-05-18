package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import exh3y.telebot.util.ObjectMapperFactory;


public class TelegramLocation
{
	
	private Float longitude;
	private Float latitude;
	
	
	public static TelegramLocation create(JSONObject json)
			throws IOException
	{
		
		ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
		return mapper.readValue(json.toString(), TelegramLocation.class);
	}
	
	
	public Float getLongitude()
	{
		
		return longitude;
	}
	
	
	public void setLongitude(Float longitude)
	{
		
		this.longitude = longitude;
	}
	
	
	public Float getLatitude()
	{
		
		return latitude;
	}
	
	
	public void setLatitude(Float latitude)
	{
		
		this.latitude = latitude;
	}
	
}
