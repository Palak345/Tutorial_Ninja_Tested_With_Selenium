package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountManagementPage {
    WebDriver driver;

    
    private By emailField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By accountDashboard = By.xpath("//h2[contains(text(),'My Account')]");

    private By profileDropdown = By.xpath("//a[@title='My Account']");
    private By myAccountOption = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']");
    private By editAccountLink = By.xpath("//a[normalize-space()='Edit your account information']");
    private By firstNameField = By.id("input-firstname");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By successMessage = By.cssSelector(".alert.alert-success");

    public AccountManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isAccountDashboardDisplayed() {
        return driver.findElements(accountDashboard).size() > 0;
    }

    public void clickProfileDropdown() {
        driver.findElement(profileDropdown).click();
    }

    public void clickMyAccount() {
        driver.findElement(myAccountOption).click();
    }

    public void clickEditAccount() {
        driver.findElement(editAccountLink).click();
    }

    public void modifyFirstName(String newName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(newName);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }
}
