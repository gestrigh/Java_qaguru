package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import guru.qa.utils.RandomUtil;
import org.junit.jupiter.api.Test;

public class  RegistrationWithRandomUtilsTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtil randomUtil = new RandomUtil();

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
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
                .checkResult("Date of Birth", randomUtil.calendarDay + " " + randomUtil.calendarMonth + ","+ randomUtil.calendarYear)
                .checkResult("Subjects", randomUtil.subjects)
                .checkResult("Hobbies", randomUtil.hobbies)
                .checkResult("Picture", randomUtil.imgName)
                .checkResult("Address", randomUtil.address)
                .checkResult("State and City", randomUtil.state + " " + randomUtil.city);
    }
    @Test
    void notFullRegistrationTest(){
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
                .checkResult("Date of Birth", randomUtil.calendarDay + " " + randomUtil.calendarMonth + ","+ randomUtil.calendarYear)
                .checkResult("Subjects", randomUtil.subjects)
                .checkResult("Hobbies", randomUtil.hobbies);
    }
    @Test
    void failRegistrationTest(){
        registrationPage.openPage()
                .clickSubmit()
                .emptyForm();
    }
}
