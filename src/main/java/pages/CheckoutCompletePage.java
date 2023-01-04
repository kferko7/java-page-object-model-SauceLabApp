package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    private By backHomeButton = By.tagName("button");

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    public void setBackHomeButton(){
        driver.findElement(backHomeButton).click();
    }
}
