package guru.qa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {

    public void checkSubmitTable(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
