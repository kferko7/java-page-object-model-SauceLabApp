package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackpackPage {

    private WebDriver driver;
    private By addToCartBackPackButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");

    private By shoppingCartBadgeButton = By.className("shopping_cart_badge");

    public BackpackPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setAddToCartBackPackButton() {
        driver.findElement(addToCartBackPackButton).click();
    }

    public void setShoppingCartBadgeButton() {
        driver.findElement(shoppingCartBadgeButton).click();
    }

    public BackpackPage clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        return new BackpackPage(driver);
    }

}

