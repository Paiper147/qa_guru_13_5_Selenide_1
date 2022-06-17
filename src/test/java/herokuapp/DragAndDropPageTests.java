package herokuapp;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class DragAndDropPageTests {
//    Запрограммируйте Drag&Drop с помощью Selenide.actions()
// - Откройте https://the-internet.herokuapp.com/drag_and_drop
// - Перенесите прямоугольник А на место В
// - Проверьте, что прямоугольники действительно поменялись
// P.S. В Selenide есть команда $(element).dragAndDrop($(to-element)),
// проверьте работает ли тест, если использовать её вместо actions()
//(раньше не работала из-за ошибки в ChromeDriver, но может быть уже починили?).

    public static final String TEST_PAGE = "https://the-internet.herokuapp.com/drag_and_drop";

    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    void dragAndDropTestFirst() {
        dragAndDropPage.openTestPage(TEST_PAGE)
                .moveAboxToBboxFirst()
                .checkResult();
    }
    @Test
    void dragAndDropTestSecond() {
        dragAndDropPage.openTestPage(TEST_PAGE)
                .moveAboxToBboxSecond()
                .checkResult();
    }
    @Test
    void dragAndDropTestThird() {
        dragAndDropPage.openTestPage(TEST_PAGE)
                .moveAboxToBboxThird()
                .checkResult();
        sleep(1000);
    }

}
