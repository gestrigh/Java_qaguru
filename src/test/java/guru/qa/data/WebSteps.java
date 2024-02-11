package guru.qa.data;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchRepository(String repo){
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repo).submit();
    }
    @Step("Кликаем по ссылке {repo}")
    public void clickOnRepository(String repo){
        $(linkText(repo)).click();
    }
    @Step("Переходим в раздел issues")
    public void clickOnIssue(){
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие issue {issue}")
    public void testIssue(String issue){
        $("#issue_1_link").shouldHave(text(issue));
    }
}
