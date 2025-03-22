package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiCurrencyPage {
    WebDriver driver;
    
    // Locators
    private By currencyDropdown = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    private By euroOption = By.xpath("//button[contains(text(),'€Euro')]");
    private By poundOption = By.xpath("//button[normalize-space()='£Pound Sterling']");
    private By dollarOption = By.xpath("//button[normalize-space()='$US Dollar']");
    private By activeCurrencySymbol = By.xpath("//button[@class='btn btn-link dropdown-toggle']");
    
    // Constructor
    public MultiCurrencyPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Method to open currency dropdown
    public void openCurrencyDropdown() {
        driver.findElement(currencyDropdown).click();
    }
    
    // Method to select a specific currency
    public void selectCurrency(String currency) {
        openCurrencyDropdown(); // Always open dropdown before selection
        
        switch (currency.toLowerCase()) {
            case "euro":
                driver.findElement(euroOption).click();
                break;
            case "pound":
                driver.findElement(poundOption).click();
                break;
            case "dollar":
                driver.findElement(dollarOption).click();
                break;
            default:
                System.out.println("Invalid currency: " + currency);
        }
    }
    
    // Method to get the currently active currency symbol
    public String getActiveCurrencySymbol() {
        WebElement activeCurrency = driver.findElement(activeCurrencySymbol);
        return activeCurrency.getText().trim();
    }
    
    // Verification method to confirm currency change
    public boolean isCurrencyChanged(String expectedCurrencySymbol) {
        String actualCurrency = getActiveCurrencySymbol();
        return actualCurrency.contains(expectedCurrencySymbol);
    }
}
