package github.selenide_wiki;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiPage {
    SelenideElement wikiTab = $("#wiki-tab");
    SelenideElement wikiPagesFilter = $("#wiki-pages-filter");
    SelenideElement wikiRrightbar= $(".wiki-rightbar");
    SelenideElement body= $(".markdown-body");

    public WikiPage openTestPage(String page){
        open(page);
        return this;
    }

    public WikiPage openWikiPage(){
        wikiTab.click();
        return this;
    }

    public WikiPage checkAndClickNeedPage(String namePage){
        wikiPagesFilter.setValue(namePage).pressEnter();
        boolean isNeedPageDisplayed = wikiRrightbar.$$("ul li").findBy(Condition.text(namePage)).isDisplayed();
        if(isNeedPageDisplayed){
            wikiRrightbar.$$("ul li").findBy(Condition.text(namePage)).click();
        } else {
            System.out.println("There is no " + namePage + " page");
        }
        return this;
    }

    public WikiPage checkResult(String needPhrase){
        body.shouldHave(Condition.text(needPhrase));
        return this;
    }
}
