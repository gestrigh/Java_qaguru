package guru.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleJUnitTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("### @BeforeAll");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("### @BeforeEach");
    }

    @Test

    void firstTest() {
        System.out.println("### @Test firstTest");
        Assertions.assertTrue(2 * 2 == 4);
    }
    @Test
    void secondTest() {
        System.out.println("### @Test secondTest");
        Assertions.assertTrue(2 + 2 == 4);
    }
}
