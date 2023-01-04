import Base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TshirtTests extends BaseTests {

    @Test
    public void TC_04_testSuccessTshirtTests() {
        var tshirtPage = homePage.clickProductTshirt();
        homePage.setCartBadgeButton();
        tshirtPage.setTshirtPrice();
        assertTrue(tshirtPage.isTshirtNameDisplayed(),"Order text is not displayed");
        System.out.println(tshirtPage.getTshirtName());
        getWindowManager().switchToNewTab();


    }
}
