package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ContributorsTest {

    public static final String FIRST_CONTRIBUTOR_NAME = "Andrei Solntsev";
    public static final String TEST_PAGE_ADDR = "https://github.com/selenide/selenide";

    @Test
    void isFirstContributorCorrect(){
        //    open repository page
        open(TEST_PAGE_ADDR);
//    bring mouse over the first avatar on contributors tab
        $(".Layout-sidebar")
                .$$("h2")
                .filterBy(Condition.text("Contributors"))
                .first()
//                .sibling(0).$$("li").first().hover();
                .parent()
                .$$("ul li")
                .first()
                .hover();
//    check: popup is showing Andrei Solntsev
        $$(".Popover-message").findBy(Condition.visible).shouldHave(Condition.text(FIRST_CONTRIBUTOR_NAME));

//        Заморозка экрана в браузере
//      1. Sources -> F8
//      2. Console -> "debugger"
//      3. Console -> setTimeout(function(){debugger;}, 3000)
    }


}
