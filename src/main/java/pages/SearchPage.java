package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;

    By searchBox = By.name("search");
    By searchButton = By.xpath("//button[@type='button' and contains(@class,'btn-default')]");
    By searchResults = By.xpath("//h4/a"); // Locator for product names
    By noResultsMessage = By.xpath("//p[contains(text(),'There is no product')]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchKeyword(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public boolean isProductDisplayed() {
        return driver.findElements(searchResults).size() > 0;
    }

    public boolean isNoResultsMessageDisplayed() {
        return driver.findElements(noResultsMessage).size() > 0;
    }
}
