package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Заполнение формы Text Box")
public class ParameterizedTests {
   @BeforeEach
   void preConditions(){
       Configuration.pageLoadStrategy = "eager";
       Configuration.browserSize = "1920x1080";
       open("https://demoqa.com/text-box");
   }

   @ValueSource(strings = {"Roma Geniy", "Roma NeGeniy"})
   @ParameterizedTest(name = "Заполнение поля full name значением {0} в форме Text Box")
    void fullNameTextBoxTests(String name){
       $("[placeholder=\"Full Name\"]").setValue(name);
       $("#submit").click();
       $("p#name").shouldHave(text(name));
    }

    @CsvSource(value = {"Roman Geniy , test@gmail.com",
            "Roman NeGeniy, test@mail.ru"
    })
    @ParameterizedTest(name = "Заполнение полей full name значением {0} и Email значением {1}")
    void fullNameAndEmailTextBoxTests(String name, String email){
        $("[placeholder=\"Full Name\"]").setValue(name);
        $("#userEmail").setValue(email);
        $("#submit").click();
        $("p#name").shouldHave(text(name));
        $("p#email").shouldHave(text(email));
    }
    @MethodSource("fullNameAndEmailAndCurrentAddressTextBoxTests")
    @ParameterizedTest(name = "Заполнение полей full name значением {0} и Email значением {1} и Current Address значенем {2}")
    void fullNameAndEmailAndCurrentAddressTextBoxTests(String name, String email, String address){
        $("[placeholder=\"Full Name\"]").setValue(name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(address);
        $("#submit").click();
        $("p#name").shouldHave(text(name));
        $("p#email").shouldHave(text(email));
        $("p#currentAddress").shouldHave(text(address));
    }
    static Stream<Arguments> fullNameAndEmailAndCurrentAddressTextBoxTests(){
       return Stream.of(
               Arguments.of("Roma Geniy","test@gmail.com", "test"),
               Arguments.of("Roma NeGeniy", "test@mail.ru", "NeTest")
       );

    }
}
