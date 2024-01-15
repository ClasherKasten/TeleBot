package exh3y.telebot.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

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
            mapper =
                    new JsonMapper.Builder(new JsonMapper())
                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                            .build();
        }
        return mapper;
    }
}
