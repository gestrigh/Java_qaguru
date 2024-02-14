package guru.qa.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.data.WebSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureTest {
    private final String REPOSITORY = "gestrigh/Java_qaguru";
    private final String issuieName = "hw 12 issue";
    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
    @Test
    @DisplayName("Тест Чистый Selenide (с Listener)")
    public void selenideSearchIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue(REPOSITORY).submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text(issuieName));
    }
    @Test
    @DisplayName("Тест Лямбда шаги через step (name, () -> {})")
    public void lambdaStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу ", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел issues " + REPOSITORY, () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие issue " + REPOSITORY, () -> {
           $("#issue_1_link").shouldHave(text(issuieName));
       });
    }
    @Test
    @DisplayName("Тест с аннотациями")
    public void annotatedStepTest(){
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository(REPOSITORY);
        steps.clickOnRepository(REPOSITORY);
        steps.clickOnIssue();
        steps.testIssue(issuieName);
    }
}
