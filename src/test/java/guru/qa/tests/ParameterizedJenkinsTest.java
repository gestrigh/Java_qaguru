package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.ProjectConfig;
import guru.qa.pages.RegistrationPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ParameterizedJenkinsTest extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    ProjectConfig projectConfig;

    @BeforeEach
    void setConfig() {
        System.setProperty("env", "test");
        projectConfig = ConfigFactory.create(ProjectConfig.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test
    @Tag("parameterizedTest")
    @DisplayName("Параметризованная форма с не полными данными")
    void parameterizedRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(projectConfig.studentName())
                .setLastName(projectConfig.studentLastName())
                .setUserEmail(projectConfig.studentEmail())
                .setGender("Male")
                .setUserNumber(projectConfig.studentNumber())
                .clickSubmit()
                .checkTable()
                .checkResult("Student Name", projectConfig.studentName() + " " + projectConfig.studentLastName())
                .checkResult("Student Email", projectConfig.studentEmail())
                .checkResult("Gender", "Male")
                .checkResult("Mobile", projectConfig.studentNumber());
    }
}
