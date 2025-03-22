package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;

    By logoutLink = By.xpath("(//a[text()='Logout'])[2]");
    By successMessage = By.xpath("//h1[contains(text(),'Account Logout')]");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }

    public boolean isLogoutSuccessful() {
        return driver.findElements(successMessage).size() > 0;
    }
}
