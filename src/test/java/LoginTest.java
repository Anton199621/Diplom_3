import data.UserMethods;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.ForgotPasswordPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import static data.URL.LOGIN_PAGE_URL;
import static org.junit.Assert.assertEquals;

public class LoginTest extends BeforeAndAfter{
    @Test
    @DisplayName("Пользователь авторизован через кнопку Войти в аккаунт")
    public void checkSuccessLoginFromMainPageButtonEnterAccount() {
        UserMethods.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.buttonCreateOrderClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Оформить заказ",buttonText);
    }
    @Test
    @DisplayName("Пользователь авторизован через кнопку Личный кабинет")
    public void checkSuccessLoginFromMainPageButtonProfile() {
        UserMethods.createUser(user);
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.buttonProfileClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Оформить заказ",buttonText);
    }
    @Test
    @DisplayName("Пользователь авторизован через кнопку Войти в форме регистрации")
    public void checkSuccessLoginFromRegistrationPageButtonEnter() {
        UserMethods.createUser(user);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage()
                .clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Оформить заказ",buttonText);
    }
    @Test
    @DisplayName("Пользователь авторизован через кнопку в форме восстановления пароля")
    public void checkSuccessLoginFromForgotPasswordPageButtonEnter() {
        UserMethods.createUser(user);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.openForgotPasswordPage().clickEnterButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        String buttonText = mainPage.buttonCreateOrderGetText();
        assertEquals("Оформить заказ",buttonText);
    }
}