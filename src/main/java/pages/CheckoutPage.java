package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By addToCartButton = By.id("button-cart");
    By shoppingCartLink = By.xpath("(//button[@type=\"button\"])[5]");
    By checkoutButton = By.xpath("(//a[@href=\"https://tutorialsninja.com/demo/index.php?route=checkout/checkout\"])[1]");
    By successMessage = By.xpath("//div[@class='alert alert-success']");
    By cartItem = By.xpath("//table[@class='table table-bordered']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public boolean isProductAddedToCart() {
        return driver.findElements(cartItem).size() > 0;
    }

    public boolean isCheckoutSuccessMessageDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }
}
