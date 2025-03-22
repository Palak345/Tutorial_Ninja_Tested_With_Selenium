package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.CheckoutPage;

public class CheckoutSteps {
    WebDriver driver;
    CheckoutPage checkoutPage;

   
    @Given("the user is on the shopping cart page with an empty cart")
    public void user_is_on_shopping_cart_page() {
        Hooks.test = Hooks.extent.createTest("Checkout Test - Empty Cart Negative Scenario");
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");
        checkoutPage = new CheckoutPage(driver);
        Hooks.test.info("User is on shopping cart page with an empty cart");
    }

    @When("the user attempts to proceed to checkout without adding any product")
    public void user_attempts_to_checkout_without_product() {
        checkoutPage.proceedToCheckout();
        Hooks.test.info("User tried to proceed to checkout without adding a product");
    }

    @Then("an error message should be displayed preventing checkout")
    public void error_message_should_be_displayed() {
        boolean errorDisplayed = driver.getPageSource().contains("Your shopping cart is empty!");
        Assert.assertTrue(errorDisplayed, "Expected error message was not displayed!");
        Hooks.test.pass("Error message displayed correctly, checkout prevented");
        driver.quit();
    }
}
   