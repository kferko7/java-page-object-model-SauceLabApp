package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutInfoPage {

    private WebDriver driver;
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.cssSelector("#postal-code");
    private By continueButton = By.id("continue");

    public CheckOutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstNameField() {
        driver.findElement(firstNameField).sendKeys("FirstName");
    }

    public void setLastNameField() {
        driver.findElement(lastNameField).sendKeys("LastName");
    }

    public void setPostalCodeField() {
        driver.findElement(postalCodeField).sendKeys("12345");
    }

    public void setContinueButton() {
        driver.findElement(continueButton).click();
    }

}
