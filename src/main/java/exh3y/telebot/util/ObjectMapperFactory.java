package exh3y.telebot.util;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;


public class ObjectMapperFactory
{
	
	/**
	 * Returns the default object mapper (used by all classes for deserialization)
	 * 
	 * @return The pre-configured mapper
	 */
	public static ObjectMapper createObjectMapper()
	{
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		return mapper;
	}
}
