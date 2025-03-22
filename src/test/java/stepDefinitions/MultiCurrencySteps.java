package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pages.MultiCurrencyPage;

public class MultiCurrencySteps {

    WebDriver driver;
    MultiCurrencyPage multiCurrencyPage;

    @Given("theee user is on the homepage")
    public void homepage() {
        Hooks.test = Hooks.extent.createTest("Multi-Currency Test");  // Initialize Extent Report
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        multiCurrencyPage = new MultiCurrencyPage(driver);
        Hooks.test.info("Navigated to homepage");
    }

    @When("the user selects {string} currency")
    public void user_selects_currency(String currency) {
        multiCurrencyPage.selectCurrency(currency);
        Hooks.test.info("Selected currency: " + currency);
    }

    @Then("the currency should change to {string}")
    public void currency_should_change_to(String expectedSymbol) {
        Assert.assertTrue(multiCurrencyPage.isCurrencyChanged(expectedSymbol),
                "Currency did not change to " + expectedSymbol);
        Hooks.test.pass("Currency changed to " + expectedSymbol);
        driver.quit();
    }
}
