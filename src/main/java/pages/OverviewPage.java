package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverviewPage {

    private WebDriver driver;

    private By quantityOrder = By.cssSelector(".cart_quantity");

    private By finishButton = By.id("finish");

    private By loadedText = By.cssSelector(".complete-header");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickQuantityOrder(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(quantityOrder)).doubleClick().build().perform();
    }

    public void clickFinish(){
        driver.findElement(finishButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
    }

    public boolean isOrderTextDisplayed(){
        return driver.findElement(loadedText).isDisplayed();
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }

    public boolean isQuantityOrderDisplayed(){
        return driver.findElement(quantityOrder).isDisplayed();
    }

}
