import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;
import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BeforeAndAfter {

    @Test
    @DisplayName("Клик по кнопке булки скроллит до булок")
    public void clickBuns() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickMenuBun();
        assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Клик по кнопке соусфы скроллит до соусов")
    public void clickSauce() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickMenuSauce();
        assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }
    @Test
    @DisplayName("Клик по кнопке начинки скроллит до Начинок")
    public void clickFillings() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickMenuFillings();
        assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }
}