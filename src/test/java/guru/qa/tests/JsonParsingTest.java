package guru.qa.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.PersonHuman;
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
            PersonHuman object = objectMapper.readValue(reader, PersonHuman.class);
            Assertions.assertEquals("Roman", object.name);
            Assertions.assertEquals(26, object.age);
            Assertions.assertArrayEquals(new String[]{"anime","games","coding"}, object.hobbie.toArray());
            Assertions.assertEquals(123456, object.passport.number);
            Assertions.assertEquals("MVD", object.passport.issuer);
            }
        }
    }

