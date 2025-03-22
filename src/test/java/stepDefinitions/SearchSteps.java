package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.SearchPage;

public class SearchSteps {
    WebDriver driver;
    SearchPage searchPage;

    @Given("is on the homepage")
    public void is_on_homepage() {
        Hooks.test = Hooks.extent.createTest("Search Test");

        if (driver == null) { // Ensure driver is initialized
            driver = new ChromeDriver();
        }

        driver.get("https://tutorialsninja.com/demo/");
        searchPage = new SearchPage(driver); // Initialize SearchPage for each scenario

        System.out.println("SearchPage initialized: " + (searchPage != null)); // Debugging statement
        Hooks.test.info("User is on the homepage");
    }

    @When("the user searches for a product with keyword {string}")
    public void user_searches_for_product(String keyword) {
        if (searchPage == null) { 
            is_on_homepage(); // Reinitialize if searchPage is null
        }

        System.out.println("Performing search for: " + keyword);
        searchPage.enterSearchKeyword(keyword);
        searchPage.clickSearch();
        Hooks.test.info("Searched for product: " + keyword);
    }

    @Then("relevant products should be displayed")
    public void relevant_products_should_be_displayed() {
        Assert.assertTrue(searchPage.isProductDisplayed(), "No products found for search keyword");
        Hooks.test.pass("Search results displayed correctly");
        driver.quit();
    }

    @Then("a no results message should be displayed")
    public void no_results_message_should_be_displayed() {
        Assert.assertTrue(searchPage.isNoResultsMessageDisplayed(), "No results message not displayed");
        Hooks.test.pass("No products found, correct message displayed");
        driver.quit();
    }
}
