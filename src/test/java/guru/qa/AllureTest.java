package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.data.RepositoryName;
import guru.qa.data.WebSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AllureTest {
    RepositoryName repositoryName = new RepositoryName();
    @Test
    @DisplayName("Тест Чистый Selenide (с Listener)")
    public void selenideSearchIssueTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repositoryName.repoName).submit();
        $(linkText(repositoryName.repoName)).click();
        $("#issues-tab").click();
        $("#issue_1_link").shouldHave(text(repositoryName.issuieName));
    }
    @Test
    @DisplayName("Тест Лямбда шаги через step (name, () -> {})")
    public void lambdaStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий" + repositoryName, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(repositoryName.repoName).submit();
        });
        step("Кликаем по ссылке репозитория" + repositoryName, () -> {
            $(linkText(repositoryName.repoName)).click();
        });
        step("Переходим в раздел issues" + repositoryName, () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие issue" + repositoryName, () -> {
           $("#issue_1_link").shouldHave(text(repositoryName.issuieName));
       });
    }
    @Test
    @DisplayName("Тест с аннотациями")
    public void annotatedStepTest(){
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository(repositoryName.repoName);
        steps.clickOnRepository(repositoryName.repoName);
        steps.clickOnIssue();
        steps.testIssue(repositoryName.issuieName);
    }
}
