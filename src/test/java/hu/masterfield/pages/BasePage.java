package hu.masterfield.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class BasePage {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        BasePage.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException e) {
            fail(e);
            return false;
        }
    }

    public boolean isInteractable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
    }
}
