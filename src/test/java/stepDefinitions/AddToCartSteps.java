package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.AddToCartPage;

public class AddToCartSteps {
    WebDriver driver;
    AddToCartPage addToCartPage;

    @Given("the user is on the homepage")
    public void user_is_on_homepage() {
        Hooks.test = Hooks.extent.createTest("Add to Cart Test");
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        addToCartPage = new AddToCartPage(driver);
        Hooks.test.info("User navigated to the homepage");
    }

    @When("the user searches for {string}")
    public void user_searches_for_product(String productName) {
        addToCartPage.searchProduct(productName);
        Hooks.test.info("Searched for product: " + productName);
    }

    @And("the user selects the product from search results")
    public void user_selects_product() {
        addToCartPage.selectProduct();
        Hooks.test.info("Selected product from search results");
    }

    @And("clicks on the add to cart button")
    public void user_clicks_add_to_cart() {
        addToCartPage.clickAddToCart();
        Hooks.test.info("Clicked on Add to Cart button");
    }
    
    @Then("the product should be added to the cart successfully")
    public void product_added_to_cart_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        // Assertion
        String expectedMessage = "Success: You have added";
        String actualMessage = successMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Expected message not found! Actual message: " + actualMessage);
    }


    //  Negative Scenario: Search for a non-existing product
    @When("the user searches for a non-existing product {string}")
    public void user_searches_for_non_existing_product(String productName) {
        addToCartPage.searchProduct(productName);
        Hooks.test.info("Searched for a non-existing product: " + productName);
    }

    @Then("no product should be displayed")
    public void no_product_should_be_displayed() {
        Assert.assertTrue(driver.getPageSource().contains("There is no product that matches the search criteria."),
                "Expected no product to be found, but results were displayed!");
        Hooks.test.pass("No product found as expected for non-existing search");
        driver.quit();
    }

    //  Negative Scenario: Open cart when empty
    @When("the user opens the cart without adding any product")
    public void user_opens_cart_without_adding_any_product() {
        addToCartPage.openCart();
        Hooks.test.info("Opened cart without adding any product");
    }

    @Then("the cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertTrue(addToCartPage.isCartEmpty(), "Expected cart to be empty, but it was not!");
        Hooks.test.pass("Cart is empty as expected");
        driver.quit();
    }
}
