package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"product-list\"]/div[2]/div[3]/div/div[1]/div[1]/div[1]/strong[2]")
    WebElement searchResultCount;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void validateSearchResultNumber(int numOfProducts) {
        assertTrue(isLoaded());
        assertTrue(searchResultCount.getText().contains("" + numOfProducts));
    }

    public boolean isLoaded() {
        boolean isLoaded = isLoaded(searchResultCount);
        return isLoaded;
    }
}
