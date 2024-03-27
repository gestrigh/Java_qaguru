package guru.qa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class GithubEnterprizePageTest extends BaseTest {
    @Test
    @Tag("hw19")
    void githubEnterprizePageTest() {
        open("https://github.com/");
        $(byTagAndText("button", "Solutions")).hover();
        $("a[href='/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered")).shouldBe(visible);
    }
}
