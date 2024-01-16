package guru.qa;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLustName("Timofeev")
                .setUserEmail("test@gmail.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setDateOfBirthday("11","January","1998")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .uploadPicture()
                .setAddress("Current Address")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();
        //Result
        registrationPage.checkResult("Student Name", "Roman Timofeev")
                .checkResult("Student Email", "test@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "11 January,1998")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Anime.png")
                .checkResult("Address", "Current Address")
                .checkResult("State and City", "NCR Delhi");
    }
    @Test
    void notFullRegistrationTest(){
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLustName("Timofeev")
                .setUserEmail("test@gmail.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setDateOfBirthday("11","January","1998")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .clickSubmit();
        registrationPage.checkResult("Student Name", "Roman Timofeev")
                .checkResult("Student Email", "test@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "11 January,1998")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Sports");
    }
    @Test
    void failRegistrationTest(){
        registrationPage.openPage()
                .clickSubmit()
                .emptyForm();
    }
}
