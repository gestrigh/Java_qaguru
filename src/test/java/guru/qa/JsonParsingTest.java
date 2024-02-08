package guru.qa;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonParsingTest {
    private final ClassLoader cl = JsonParsingTest.class.getClassLoader();
    @Test
    @DisplayName("Парсинг json с помощью Jackson")
    void jsonParsingTest() throws Exception{
        try (InputStream is = cl.getResourceAsStream("Person.json"); Reader reader = new InputStreamReader(is)){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(reader, JsonNode.class);
            Assertions.assertEquals("");

            }
        }
    }

