package exh3y.telebot.data;

import java.io.IOException;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import exh3y.telebot.data.enums.ETelegramChatType;
import exh3y.telebot.util.ObjectMapperFactory;


public class TelegramChat
{
	
	private int id;
	private ETelegramChatType type;
	
	private String title = null;
	private String username = null;
	private String first_name = null;
	private String last_name = null;
	private Boolean all_members_are_administrators = false;
	
	
	public static TelegramChat create(JSONObject json) throws IOException
	{
		
		ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();
		return mapper.readValue(json.toString(), TelegramChat.class);
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		
		if (super.equals(obj))
		{
			return true;
		}
		
		if (obj instanceof TelegramChat)
		{
			return ((TelegramChat) obj).getId() == this.getId();
		}
		
		return false;
	}
	
	
	/**
	 * Returns the chat's type
	 * 
	 * @return The chat's type
	 * @since 0.0.6
	 */
	public ETelegramChatType getType()
	{
		
		return type;
	}
	
	
	/**
	 * Returns the chat's id
	 * 
	 * @return The chat's id
	 * @since 0.0.6
	 */
	public int getId()
	{
		
		return this.id;
	}
	
	
	/**
	 * @param id
	 *           the id to set
	 */
	public void setId(int id)
	{
		
		this.id = id;
	}
	
	
	/**
	 * @param type
	 *           the type to set
	 */
	@JsonProperty
	public void setType(String type)
	{
		
		this.type = ETelegramChatType.getEnumByName(type);
	}
	
	
	public boolean hasTitle()
	{
		
		return title != null;
	}
	
	
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		
		return title;
	}
	
	
	/**
	 * @param title
	 *           the title to set
	 */
	public void setTitle(String title)
	{
		
		this.title = title;
	}
	
	
	public boolean hasUsername()
	{
		
		return username != null;
	}
	
	
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		
		return username;
	}
	
	
	/**
	 * @param username
	 *           the username to set
	 */
	public void setUsername(String username)
	{
		
		this.username = username;
	}
	
	
	public boolean hasFirst_name()
	{
		
		return first_name != null;
	}
	
	
	/**
	 * @return the first_name
	 */
	public String getFirst_name()
	{
		
		return first_name;
	}
	
	
	/**
	 * @param first_name
	 *           the first_name to set
	 */
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
	
	
	/**
	 * @return the all_members_are_administrators
	 */
	public Boolean getAll_members_are_administrators()
	{
		
		return all_members_are_administrators;
	}
	
	
	/**
	 * @param all_members_are_administrators
	 *           the all_members_are_administrators to set
	 */
	public void setAll_members_are_administrators(Boolean all_members_are_administrators)
	{
		
		this.all_members_are_administrators = all_members_are_administrators;
	}
	
	
	/**
	 * @param type
	 *           the type to set
	 */
	public void setType(ETelegramChatType type)
	{
		
		this.type = type;
	}
	
}
