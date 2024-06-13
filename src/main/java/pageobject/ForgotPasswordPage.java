package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static data.URL.*;

public class ForgotPasswordPage {
    private final WebDriver driver;
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private static final By LOGIN_ENTER_BUTTON = By.xpath(".//*[text()='Войти']");
    @Step("Восстановление пароля")
    public ForgotPasswordPage openForgotPasswordPage() {
        driver.get(FORGOT_PASSWORD_PAGE_URL);
        (new WebDriverWait(driver, Duration.ofSeconds(15))).until(ExpectedConditions.urlToBe(FORGOT_PASSWORD_PAGE_URL));
        return this;
    }
    @Step("Войти на странице восстановления пароля")
    public void clickEnterButton() {
        driver.findElement(LOGIN_ENTER_BUTTON).click();
    }
}