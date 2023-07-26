package util;

import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonUtils {
    public static String createJsonString(List<Map<String, String>> data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(data.get(0));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}