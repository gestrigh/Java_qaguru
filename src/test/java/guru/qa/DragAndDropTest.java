package guru.qa;

import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void actionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions()
                .moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"))
                .release()
                .perform();
        $("#column-a").$(byTagAndText("header","B")).shouldBe(visible);
    }
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-b").$(byTagAndText("header","A")).shouldBe(visible);
        $("#column-a").$(byTagAndText("header","B")).shouldBe(visible);
    }
}

