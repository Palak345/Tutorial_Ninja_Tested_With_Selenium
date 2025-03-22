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
import pages.RegisterPage;

public class RegisterSteps {
    WebDriver driver;
    RegisterPage registerPage;

    @Given("the user is on the registration page")
    public void user_is_on_registration_page() {
        Hooks.test = Hooks.extent.createTest("Register Test");
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        registerPage = new RegisterPage(driver);
        Hooks.test.info("User is on registration page");
    }

    @When("the user enters valid registration details")
    public void user_enters_registration_details() {
        registerPage.enterDetails("Palak", "Mangal", "palakk" + System.currentTimeMillis() + "@example.com", "1234567890", "password123", "password123");
        registerPage.agreeToTerms();
        registerPage.clickContinue();
        Hooks.test.info("User entered valid registration details");
    }

    @Then("the user should be registered successfully")
    public void user_should_be_registered() {
        Assert.assertTrue(registerPage.isRegistrationSuccessDisplayed(), "Registration success message not displayed!");
        Hooks.test.pass("User registered successfully!");
        driver.quit();
    }

    @When("the user enters mismatched passwords")
    public void user_enters_mismatched_passwords() {
        registerPage.enterDetails("Palak", "Mangal", "palakk@example.com", "1234567890", "password123", "wrongpass");
        registerPage.agreeToTerms();
        registerPage.clickContinue();
        Hooks.test.info("User entered mismatched passwords");
    }

    @Then("registration error message should be displayed")
    public void registration_error_message_should_be_displayed() {
//        Assert.assertTrue(registerPage.isErrorMessageDisplayed(), "Expected error message not displayed!");
//        Hooks.test.fail("User registration failed due to mismatched passwords!");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-danger']")));
        
        Assert.assertTrue(errorMessage.isDisplayed(), "Expected error message not displayed!");
        driver.quit();
    }

    @When("the user does not agree to terms")
    public void user_does_not_agree_to_terms() {
        registerPage.enterDetails("Palak", "Mangal", "palakk@example.com", "1234567890", "password123", "password123");
        registerPage.clickContinue();
        Hooks.test.info("User skipped agreeing to terms");
    }

    @Then("a terms agreement error message should be displayed")
    public void terms_agreement_error_message_should_be_displayed() {
        Assert.assertTrue(registerPage.isErrorMessageDisplayed(), "Expected terms agreement error message not displayed!");
        Hooks.test.fail("User registration failed due to not agreeing to terms!");
        driver.quit();
    }
}
