package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By cartBadgeButton = By.cssSelector(".shopping_cart_badge");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void setCartBadgeButton() {
       //this.cartBadgeButton =  cartBadgeButton;
       driver.findElement(cartBadgeButton).click();
    }

    public BackpackPage clickProductBackPack(){
        WebElement productBackPack = driver.findElement(By.id("item_4_title_link"));
        productBackPack.click();
        return new BackpackPage(driver);
    }

    public DropdownPage clickDropdown(){
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        dropdown.click();
        return new DropdownPage(driver);
    }

    public TshirtPage clickProductTshirt(){
        WebElement productTshirt = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        productTshirt.click();
        return new TshirtPage(driver);
    }



}