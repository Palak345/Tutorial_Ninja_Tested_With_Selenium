package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;

    private By siteLogo = By.cssSelector("#logo a");
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Check if a main navigation link is visible
    public boolean isNavigationLinkVisible(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        return link.isDisplayed();
    }

    // Check if a main navigation link is clickable
    public boolean isNavigationLinkClickable(String linkText) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
        return link.isEnabled();
    }

    // Check if a footer link is visible
    public boolean isFooterLinkVisible(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        return link.isDisplayed();
    }

    // Check if a footer link is clickable
    public boolean isFooterLinkClickable(String linkText) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
        return link.isEnabled();
    }
    
    public boolean isLogoVisible() {
        WebElement logo = driver.findElement(siteLogo);
        return logo.isDisplayed();
    }

    public boolean isLogoClickable() {
        WebElement logo = driver.findElement(siteLogo);
        return logo.isEnabled();
    }
}
