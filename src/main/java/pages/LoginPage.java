package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//input[@value='Login']");
    By accountDashboard = By.xpath("//h2[contains(text(),'My Account')]");
    By loginErrorMessage = By.xpath("//div[contains(@class,'alert-danger')]");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    public boolean isAccountDashboardDisplayed() {
        return driver.findElements(accountDashboard).size() > 0;
    }
    
    public boolean isLoginErrorMessageDisplayed() {
        return driver.findElements(loginErrorMessage).size() > 0;
    }
}