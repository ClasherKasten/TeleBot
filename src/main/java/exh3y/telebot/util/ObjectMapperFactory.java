package exh3y.telebot.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {

    private static ObjectMapper mapper = null;

    private ObjectMapperFactory() {}

    /**
     * Returns the default object mapper (used by all classes for deserialization)
     *
     * @return The pre-configured mapper
     */
    public static ObjectMapper createObjectMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
        return mapper;
    }
}
