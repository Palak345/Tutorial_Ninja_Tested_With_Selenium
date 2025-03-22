package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.LogoutPage;
import pages.LoginPage;

public class LogoutSteps {
    WebDriver driver;
    LoginPage loginPage;
    LogoutPage logoutPage;

    @Given("the user is logged into their account")
    public void user_is_logged_into_account() {
        Hooks.test = Hooks.extent.createTest("Logout Test"); 
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);

        loginPage.enterEmail("validuser@example.com");
        loginPage.enterPassword("validpassword");
        loginPage.clickLogin();
        Hooks.test.info("User logged in successfully");
    }

    @When("the user clicks on the logout button")
    public void user_clicks_logout_button() {
        logoutPage.clickLogout();
        Hooks.test.info("Clicked on Logout button");
    }

    @Then("the user should be logged out and see the logout confirmation message")
    public void user_sees_logout_message() {
        if (logoutPage.isLogoutSuccessful()) {
            Hooks.test.pass("Logout successful");
            Assert.assertTrue(true);
        } else {
            Hooks.test.fail("Logout failed");
            Assert.fail("Logout message not displayed");
        }
        driver.quit();
    }
}
