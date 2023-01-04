package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By cartQuantity = By.cssSelector(".cart_quantity");

    private By itemPrice = By.className("inventory_item_price");

    private By checkoutButton = By.id("checkout");

    private By continueShoppingButton = By.name("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCartQuantity() {
        driver.findElement(cartQuantity).click();
    }

    public void setItemPrice() {
        driver.findElement(itemPrice).click();
    }

    public void setCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void setContinueShoppingButton() {
        driver.findElement(continueShoppingButton).click();
    }
}
