package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationWithRandomUtilsTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirthday(testData.calendarDay, testData.calendarMonth, testData.calendarYear)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .uploadPicture()
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmit()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.calendarDay + " " + testData.calendarMonth + ","+ testData.calendarYear)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.imgName)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }
    @Test
    void notFullRegistrationTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirthday(testData.calendarDay, testData.calendarMonth, testData.calendarYear)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .clickSubmit()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.calendarDay + " " + testData.calendarMonth + ","+ testData.calendarYear)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies);
    }
    @Test
    void failRegistrationTest(){
        registrationPage.openPage()
                .clickSubmit()
                .emptyForm();
    }
}
