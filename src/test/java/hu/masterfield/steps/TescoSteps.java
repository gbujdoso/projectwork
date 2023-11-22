package hu.masterfield.steps;

import hu.masterfield.pages.HomePage;
import hu.masterfield.pages.SearchResultPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TescoSteps {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    private HomePage homePage;
    private SearchResultPage searchResultPage;

    /* Selenium Webdriver elindítása */
    @BeforeAll
    public static void setup() {
        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900));
    }

    @AfterAll
    public static void cleanup() {
        driver.quit();
    }

    @Given("I open the home page")
    public void iOpenTheHomePage() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
        homePage = new HomePage(driver);
        homePage.isLoaded();
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        homePage.acceptCookies();
    }

    @When("I search for {string}")
    public void iSearchFor(String productName) {
        searchResultPage = homePage.search(productName);
    }

    @Then("{int} products are displayed")
    public void productsAreDisplayed(int numOfProducts) {
        searchResultPage.validateSearchResultNumber(numOfProducts);
    }

    @And("the product's name contains {string}")
    public void theProductSNameContains(String searchWord) {
    }

    @When("I search for the {string}")
    public void iSearchForThe(String searchWord) {
    }

    @And("a product's name contains the {string}")
    public void aProductSNameContainsThe(String searchWord) {
    }

    @Then("search function does nothing")
    public void searchFunctionDoesNothing() {
    }

    @Then("message displayed that the search didn't find anything")
    public void messageDisplayedThatTheSearchDidnTFindAnything() {
    }

    @And("{string} button is available")
    public void buttonIsAvailable(String buttonLabel) {
    }

    @Then("{string} products are displayed")
    public void productsAreDisplayed(String product) {
    }

    @Given("I open main page")
    public void iOpenMainPage() {
    }

    @When("I login with the following user:")
    public void iLoginWithTheFollowingUser() {
    }

    @Then("header contains the word {string}")
    public void headerContainsTheWord(String word) {
    }

    @When("click on the logout button")
    public void clickOnTheLogoutButton() {
    }

    @Then("login button is present")
    public void loginButtonIsPresent() {
    }

}
