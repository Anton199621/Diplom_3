import data.UserMethods;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import java.time.Duration;
import static data.URL.*;
import static org.junit.Assert.assertEquals;

public class ProfilePageTest extends BeforeAndAfter{
    @Test
    @DisplayName("При клике на кнопку личный кабинет, пользователь не авторизован")
    public void checkUserNoAuthClickProfileButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.buttonProfileClick();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При запросе по прямой ссылке, пользователь не авторизован")
    public void checkUserNoAuthGetProfileURLDirectly() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        driver.get(PROFILE_URL);
        assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При клике на кнопку личный кабинет, пользователь авторизован")
    public void checkUserWithAuthClickProfileButton() {
        UserMethods.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.buttonProfileClick();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(PROFILE_URL));
        assertEquals(PROFILE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При клике по логотипу переход на страницу профиля")
    public void checkClickLogo() {
        UserMethods.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.buttonProfileClick();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogo();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(BASE_URL));
        assertEquals(BASE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При кликемпо кнопке «Выйти» в личном кабинете")
    public void checkClickExitButton() {
        UserMethods.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage().authorization(user.getEmail(), user.getPassword());
        loginPage.clickEnterButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.buttonProfileClick();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickExitButton();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());

    }
}