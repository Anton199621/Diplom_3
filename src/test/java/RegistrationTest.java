import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.RegistrationPage;
import java.time.Duration;
import static data.URL.*;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BeforeAndAfter{
    @Test
    @DisplayName("Регистрация пользователя с паролем из 6 символов")
    public void successRegistrationWithAllCorrectFields() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user)
                .clickRegistrationButton();
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
        assertEquals(LOGIN_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("Регистрация пользователя с паролем из 5 символов")
    public void registrationWithPasswordFiveSymbols() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user.setPassword("11111");
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user)
                .clickRegistrationButton();
        assertEquals(REGISTER_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При регистрации пользователя, все поля не заполнены")
    public void registrationWithNoAnyData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user.setName("");
        user.setPassword("");
        user.setEmail("");
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user);
        assertEquals(REGISTER_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При регистрации, все поля заполнены, кроме поля имя")
    public void registrationWithNoNameData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user.setName("");
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user);
        assertEquals(REGISTER_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При регистрации, все поля заполнены, кроме поля почты")
    public void registrationWithNoEmailData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user.setEmail("");
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user);
        assertEquals(REGISTER_PAGE_URL,driver.getCurrentUrl());
    }
    @Test
    @DisplayName("При регистрации, все поля заполнены, кроме поля пароль")
    public void registrationWithNoPasswordData() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        user.setPassword("");
        registrationPage.openRegisterPage()
                .enterUserDataForRegistration(user);
        assertEquals(REGISTER_PAGE_URL,driver.getCurrentUrl());
    }
}