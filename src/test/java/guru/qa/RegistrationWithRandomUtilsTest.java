package guru.qa;

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
                .setState("NCR")
                .setCity("Delhi")
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
                .checkResult("State and City", "NCR Delhi");
    }
    @Test
    void notFullRegistrationTest(){
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName("Timofeev")
                .setUserEmail("test@gmail.com")
                .setGender("Male")
                .setUserNumber("0123456789")
                .setDateOfBirthday("11","January","1998")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .clickSubmit()
                .checkResult("Student Name", "Roman Timofeev")
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
