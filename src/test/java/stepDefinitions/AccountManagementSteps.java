package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.AccountManagementPage;

public class AccountManagementSteps {
    WebDriver driver;
    AccountManagementPage accountPage;

    @Given("the user is logged in and on the profile page")
    public void user_is_logged_in_on_profile_page() {
        Hooks.test = Hooks.extent.createTest("Account Management Test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
        
        accountPage = new AccountManagementPage(driver);
        Hooks.test.info("Navigated to Login Page");
        
        // Login before accessing account management
        accountPage.login("validuser@example.com", "validpassword");
        Assert.assertTrue(accountPage.isAccountDashboardDisplayed(), "Login failed!");
        Hooks.test.pass("User logged in successfully.");
    }

    @When("the user clicks on the profile dropdown")
    public void user_clicks_profile_dropdown() {
        accountPage.clickProfileDropdown();
        Hooks.test.info("Clicked on profile dropdown.");
    }

    @And("selects My Account")
    public void selects_my_account() {
        accountPage.clickMyAccount();
        Hooks.test.info("Navigated to My Account page.");
    }

    @And("edits the account information")
    public void edits_account_information() {
        accountPage.clickEditAccount();
        Hooks.test.info("Clicked on Edit Account Information.");
    }

    @And("modifies the first name to {string}")
    public void modifies_first_name(String newName) {
        accountPage.modifyFirstName(newName);
        Hooks.test.info("Modified first name to: " + newName);
    }

    @Then("clicks the continue button")
    public void clicks_continue_button() {
        accountPage.clickContinueButton();
        Assert.assertTrue(accountPage.isSuccessMessageDisplayed(), "Success message not displayed!");
        Hooks.test.pass("Account information updated successfully.");
        driver.quit();
    }
}
