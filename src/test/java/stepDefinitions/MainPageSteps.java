package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.MainPage;

public class MainPageSteps {
    WebDriver driver;
    MainPage mainPage;

    @Given("the user is on the home page")
    public void user_is_on_home_page() {
        Hooks.test = Hooks.extent.createTest("Main Page Navigation Test");  
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        mainPage = new MainPage(driver);
        Hooks.test.info("Navigated to Home Page");
    }

    @Then("all main navigation links should be visible and clickable")
    public void all_main_navigation_links_should_be_visible_and_clickable() {
        Assert.assertTrue(mainPage.isNavigationLinkVisible("Desktops"), "Desktops link is not visible");
        Assert.assertTrue(mainPage.isNavigationLinkClickable("Desktops"), "Desktops link is not clickable");

        Assert.assertTrue(mainPage.isNavigationLinkVisible("Laptops & Notebooks"), "Laptops & Notebooks link is not visible");
        Assert.assertTrue(mainPage.isNavigationLinkClickable("Laptops & Notebooks"), "Laptops & Notebooks link is not clickable");

        Assert.assertTrue(mainPage.isNavigationLinkVisible("Components"), "Components link is not visible");
        Assert.assertTrue(mainPage.isNavigationLinkClickable("Components"), "Components link is not clickable");

        Hooks.test.pass("All main navigation links are visible and clickable.");
    }

    @Then("all footer links should be visible and clickable")
    public void all_footer_links_should_be_visible_and_clickable() {
        Assert.assertTrue(mainPage.isFooterLinkVisible("About Us"), "About Us link is not visible");
        Assert.assertTrue(mainPage.isFooterLinkClickable("About Us"), "About Us link is not clickable");

        Assert.assertTrue(mainPage.isFooterLinkVisible("Contact Us"), "Contact Us link is not visible");
        Assert.assertTrue(mainPage.isFooterLinkClickable("Contact Us"), "Contact Us link is not clickable");

        Assert.assertTrue(mainPage.isFooterLinkVisible("Privacy Policy"), "Privacy Policy link is not visible");
        Assert.assertTrue(mainPage.isFooterLinkClickable("Privacy Policy"), "Privacy Policy link is not clickable");

        Hooks.test.pass("All footer links are visible and clickable.");
        
    }
    
    @Then("the site logo should be visible and clickable")
    public void logo_should_be_visible_and_clickable() {
        Assert.assertTrue(mainPage.isLogoVisible(), "Logo is not visible!");
        Assert.assertTrue(mainPage.isLogoClickable(), "Logo is not clickable!");
        Hooks.test.pass("Site logo is visible and clickable.");
    }

    @Then("close the browser")
    public void close_browser() {
        driver.quit();
        Hooks.test.info("Closed the browser.");
    }
}
