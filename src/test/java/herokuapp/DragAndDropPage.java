package herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropPage {

    SelenideElement aBox = $("#column-a");
    SelenideElement bBox = $("#column-b");
    public DragAndDropPage openTestPage(String testPage){
        open(testPage);
        return this;
    }

    public DragAndDropPage moveAboxToBboxFirst(){
        actions().moveToElement(aBox).clickAndHold().moveToElement(bBox).perform();
        return this;
    }

    public DragAndDropPage moveAboxToBboxSecond(){
        actions().dragAndDrop(aBox, bBox).build().perform();
        return this;
    }
    public DragAndDropPage moveAboxToBboxThird(){
        aBox.dragAndDropTo(bBox);
        return this;
    }

    public DragAndDropPage checkResult(){
        aBox.shouldHave(Condition.text("B"));
        bBox.shouldHave(Condition.text("A"));
        return this;
    }
}
