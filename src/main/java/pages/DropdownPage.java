package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;

    private By dropdown = By.className("product_sort_container");


    public DropdownPage(WebDriver driver){
        this.driver =driver;
    }

    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void addMultipleAttribute(){
        String script = "arguments[0].setAttribute('multiple','')";
        ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

}

