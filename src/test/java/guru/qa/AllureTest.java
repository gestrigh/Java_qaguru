package guru.qa;

import com.codeborne.selenide.Condition;
import guru.qa.data.RepositoryName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureTest {
    RepositoryName repositoryName = new RepositoryName();
    @Test
    public void selenideSearchIssueTest(){
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue(repositoryName.repoName).submit();
        $(linkText(repositoryName.repoName)).click();
        $("#issues-tab").click();
        $(withText(repositoryName.repoName)).shouldHave(text(repositoryName.issuieName));
    }

}
