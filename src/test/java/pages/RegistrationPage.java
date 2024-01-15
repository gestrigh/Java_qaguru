package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.BaseTest;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegistrationPage extends BaseTest {
    public static SelenideElement firstNameInput = $("#firstName"),
                                lustNameInput = $("#lastName"),
                                userEmailInput = $("#userEmail"),
                                genderInput = $("#genterWrapper"),
                                userNumberInput = $("#userNumber"),
                                calendarInput = $("#dateOfBirthInput"),
                                subjectsInput = $("#subjectsInput"),
                                hobbiesInput = $("#hobbiesWrapper"),
                                pictureInput = $("#uploadPicture"),
                                addressInput = $("#currentAddress"),
                                stateInput = $("#state"),
                                cityInput = $("#city"),
                                stateCityWrapper = $("#stateCity-wrapper"),
                                submitButton =  $("#submit");
    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLustName(String value) {
        lustNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirthday(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadPicture() {
        String imgName = "Anime.png";
        pictureInput.uploadFromClasspath(imgName);
        return this;
    }
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value).click();
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage clickSubmit()
    {
        submitButton.click();
        return this;
    }
    public RegistrationPage checkResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
