package github.selenide_wiki;

import org.junit.jupiter.api.Test;

public class WikiPageTests {

    public static final String TEST_PAGE_ADDR = "https://github.com/selenide/selenide";
    public static final String NEED_PAGE = "SoftAssertions";
    public static final String NEED_PHRASE = "JUnit5";

    @Test
    void isPageContainsSomeExampleCode(){
//        - Откройте страницу Selenide в Github
//        - Перейдите в раздел Wiki проекта
//        - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//        - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        WikiPage wikiPage = new WikiPage();

        wikiPage.openTestPage(TEST_PAGE_ADDR)
                .openWikiPage()
                .checkAndClickNeedPage(NEED_PAGE)
                .checkResult(NEED_PHRASE);
    }

}
