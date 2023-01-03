package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
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

}