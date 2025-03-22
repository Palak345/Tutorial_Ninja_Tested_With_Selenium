package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {
    WebDriver driver;

    By searchBox = By.name("search");
    By searchButton = By.xpath("//button[contains(@class, 'btn-default')]");
    By productLink = By.linkText("MacBook"); 
    By addToCartButton = By.id("button-cart");
    By successMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By cartButton = By.id("cart"); 
    By emptyCartMessage = By.xpath("//p[contains(text(),'Your shopping cart is empty!')]");

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void selectProduct() {
        driver.findElement(productLink).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getSuccessMessage() {
        WebElement messageElement = driver.findElement(successMessage);
        return messageElement.getText();
    }

    public void openCart() {
        driver.findElement(cartButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(emptyCartMessage).size() > 0;
    }
}
