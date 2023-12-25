package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FillFormTests extends BaseTest {
    @BeforeAll
    static void settings() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
    }
    @Test
    void fillFormTest() {
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Timofeev");
        $("#userEmail").setValue("test@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");

        //DateOfBirthday
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--011").click();

        //Subjects
        $("#subjectsInput").setValue("Arts").pressEnter();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Picture
        String imgName = "Anime.png";
        $("#uploadPicture").uploadFromClasspath(imgName);

        //Address
        $("#currentAddress").setValue("Current Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //Submit
        $("#submit").click();

        //Result
        $(".table").shouldHave(text("Roman"));
        $(".table").shouldHave(text("Timofeev"));
        $(".table").shouldHave(text("test@gmail.com"));
        $(".table").shouldHave(text("0123456789"));
        $(".table").shouldHave(text("11 January,1998"));
        $(".table").shouldHave(text("Arts"));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text("Sports"));
        $(".table").shouldHave(text("Reading"));
        $(".table").shouldHave(text("Music"));
        $(".table").shouldHave(text(imgName));
        $(".table").shouldHave(text("Current Address"));
        $(".table").shouldHave(text("NCR Delhi"));




    }


}
