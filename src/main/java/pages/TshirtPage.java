package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TshirtPage {

    private WebDriver driver;

    private By tshirtPrice = By.cssSelector(".inventory_item_price");

    public TshirtPage(WebDriver driver) {
        this.driver = driver;

    }

    public void setTshirtPrice() {
        driver.findElement(tshirtPrice).click();
      }
    public boolean isTshirtNameDisplayed(){
        return driver.findElement(tshirtPrice).isDisplayed();
    }
    public String getTshirtName(){
        return driver.findElement(tshirtPrice).getText();
    }

}
