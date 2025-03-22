package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By number = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By agreeCheckbox = By.name("agree");
    By continueButton = By.xpath("//input[@value='Continue']");
    By successMessage = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By errorMessage = By.className("alert-danger");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String fName, String lName, String mail, String tel, String pass, String confirmPass) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(number).sendKeys(tel);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(confirmPass);
    }

    public void agreeToTerms() {
        driver.findElement(agreeCheckbox).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isRegistrationSuccessDisplayed() {
        return driver.findElements(successMessage).size() > 0;
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
