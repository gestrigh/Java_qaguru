package guru.qa.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.ResultsTableComponent;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
                                lastNameInput = $("#lastName"),
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
                                submitButton =  $("#submit"),
                                resultTable = $(".modal-content");
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    @Step("Открыть страницу automation-practice-form и удалить футер")
    public RegistrationPage openPage() {
        if (Objects.equals(Configuration.remote, "https://user1:1234@selenoid.autotests.cloud/wd/hub"))
        {
            $(".fc-button-label").shouldHave(text("Consent")).click();
        }
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Заполнить поле Имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    @Step("Заполнить поле Фамилия")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Заполнить поле Email")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Выбрать Гендер")
    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }
    @Step("Заполнить поле Номер телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Заполнить поле Дата рождения")
    public RegistrationPage setDateOfBirthday(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    @Step("Заполнить поле Уроки")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Заполнить поле Хобби")
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    @Step("Загрузить картинку профиля")
    public RegistrationPage uploadPicture() {
        String imgName = "Anime.png";
        pictureInput.uploadFromClasspath(imgName);
        return this;
    }
    @Step("Заполнить поле Адрес")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value).click();
        return this;
    }
    @Step("Заполнить поле Штат")
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Заполнить поле Город")
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Нажать на кнопку Отправить")
    public RegistrationPage clickSubmit()
    {
        submitButton.click();
        return this;
    }
    @Step("Проверка данных в таблице после регистрации")
    public RegistrationPage checkResult(String key, String value){
        resultsTableComponent.checkSubmitTable(key, value);
        return this;
    }
    @Step("Проверка валидации формы регистрации")
    public RegistrationPage emptyForm(){
        resultTable.shouldBe(hidden);
        return this;
    }
}
