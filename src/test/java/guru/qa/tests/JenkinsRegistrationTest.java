package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import guru.qa.helpers.Attach;
import guru.qa.pages.RegistrationPage;
import guru.qa.utils.RandomUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Demoqa tests")
@Story("Automation-practice-form")
@Tag("Registration")
@Owner("rtimofeev")
public class JenkinsRegistrationTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtil randomUtil = new RandomUtil();

    @Test
    @DisplayName("Успешный тест заполнения формы")
    void successRegistrationTest() {
        registrationPage
                .openPage()
                .setFirstName(randomUtil.firstName)
                .setLastName(randomUtil.lastName)
                .setUserEmail(randomUtil.userEmail)
                .setGender(randomUtil.gender)
                .setUserNumber(randomUtil.userNumber)
                .setDateOfBirthday(randomUtil.calendarDay, randomUtil.calendarMonth, randomUtil.calendarYear)
                .setSubjects(randomUtil.subjects)
                .setHobbies(randomUtil.hobbies)
                .uploadPicture()
                .setAddress(randomUtil.address)
                .setState(randomUtil.state)
                .setCity(randomUtil.city)
                .clickSubmit()
                .checkResult("Student Name", randomUtil.firstName + " " + randomUtil.lastName)
                .checkResult("Student Email", randomUtil.userEmail)
                .checkResult("Gender", randomUtil.gender)
                .checkResult("Mobile", randomUtil.userNumber)
                .checkResult("Date of Birth", randomUtil.calendarDay + " " + randomUtil.calendarMonth + "," + randomUtil.calendarYear)
                .checkResult("Subjects", randomUtil.subjects)
                .checkResult("Hobbies", randomUtil.hobbies)
                .checkResult("Picture", randomUtil.imgName)
                .checkResult("Address", randomUtil.address)
                .checkResult("State and City", randomUtil.state + " " + randomUtil.city);
    }

    @Test
    @DisplayName("Форма с не полными данными")
    void notFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(randomUtil.firstName)
                .setLastName(randomUtil.lastName)
                .setUserEmail(randomUtil.userEmail)
                .setGender(randomUtil.gender)
                .setUserNumber(randomUtil.userNumber)
                .setDateOfBirthday(randomUtil.calendarDay, randomUtil.calendarMonth, randomUtil.calendarYear)
                .setSubjects(randomUtil.subjects)
                .setHobbies(randomUtil.hobbies)
                .clickSubmit()
                .checkResult("Student Name", randomUtil.firstName + " " + randomUtil.lastName)
                .checkResult("Student Email", randomUtil.userEmail)
                .checkResult("Gender", randomUtil.gender)
                .checkResult("Mobile", randomUtil.userNumber)
                .checkResult("Date of Birth", randomUtil.calendarDay + " " + randomUtil.calendarMonth + "," + randomUtil.calendarYear)
                .checkResult("Subjects", randomUtil.subjects)
                .checkResult("Hobbies", randomUtil.hobbies);
    }

    @Test
    @DisplayName("Негативный тест")
    void failRegistrationTest() {
        registrationPage.openPage()
                .clickSubmit()
                .emptyForm();
    }
}
