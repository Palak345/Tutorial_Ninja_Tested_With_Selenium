package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
        Hooks.test = Hooks.extent.createTest("Login Test");  // Use Hooks.extent
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        loginPage = new LoginPage(driver);
        Hooks.test.info("Navigated to Login Page");
    }

    @When("the user logs in with {string} and {string}")
    public void user_logs_in_with_credentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        Hooks.test.info("Entered credentials: " + email);
    }

    @And("clicks on the login button")
    public void clicks_login_button() {
        loginPage.clickLogin();
        Hooks.test.info("Clicked Login button");
    }

    @Then("the user should be redirected to the account dashboard if credentials are valid")
    public void user_redirected_to_dashboard_if_valid() {
        if (loginPage.isAccountDashboardDisplayed()) {
            Hooks.test.pass("Login successful, redirected to account dashboard");
            Assert.assertTrue(true);
        } else {
            Hooks.test.fail("Login failed, error message displayed");
            Assert.assertTrue(loginPage.isLoginErrorMessageDisplayed(), "Expected error message but not displayed");
        }
        driver.quit();
    }
}
