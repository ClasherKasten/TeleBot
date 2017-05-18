package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import exh3y.telebot.util.ObjectMapperFactory;


public class TelegramContact
{
	
	private String phone_number;
	private String first_name;
	
	private String last_name = null;
	private Integer user_id = null;
	
	
	public static TelegramContact create(JSONObject json) throws IOException
	{
		
		ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
		return mapper.readValue(json.toString(), TelegramContact.class);
	}
	
	
	public String getPhone_number()
	{
		
		return phone_number;
	}
	
	
	public void setPhone_number(String phone_number)
	{
		
		this.phone_number = phone_number;
	}
	
	
	public String getFirst_name()
	{
		
		return first_name;
	}
	
	
	public void setFirst_name(String first_name)
	{
		
		this.first_name = first_name;
	}
	
	
	public boolean hasLast_name()
	{
		
		return last_name != null;
	}
	
	
	/**
	 * @return the last_name
	 */
	public String getLast_name()
	{
		
		return last_name;
	}
	
	
	/**
	 * @param last_name
	 *           the last_name to set
	 */
	public void setLast_name(String last_name)
	{
		
		this.last_name = last_name;
	}
	
	
	public boolean hasUser_id()
	{
		
		return user_id != null;
	}
	
	
	/**
	 * @return the user_id
	 */
	public Integer getUser_id()
	{
		
		return user_id;
	}
	
	
	/**
	 * @param user_id
	 *           the user_id to set
	 */
	public void setUser_id(Integer user_id)
	{
		
		this.user_id = user_id;
	}
	
}
