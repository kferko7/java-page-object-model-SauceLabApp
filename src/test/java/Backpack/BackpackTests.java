package Backpack;

import Base.BaseTests;
import org.testng.annotations.Test;
import pages.BackpackPage;
import pages.CheckOutInfoPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class BackpackTests  extends BaseTests {

    @Test
    public void TC_02_testSuccessBackPack() throws InterruptedException {
        var backpackPage = homePage.clickProductBackPack();
        backpackPage.setAddToCartBackPackButton();
        backpackPage.setShoppingCartBadgeButton();
        backpackPage.clickCheckoutButton();
        checkOutInfoPage.setFirstNameField();
        checkOutInfoPage.setLastNameField();
        checkOutInfoPage.setPostalCodeField();
        checkOutInfoPage.setContinueButton();
        overviewPage.clickQuantityOrder();
        assertTrue(overviewPage.isQuantityOrderDisplayed(),"Quantity Order is not displayed");
        overviewPage.clickFinish();
        assertTrue(overviewPage.isOrderTextDisplayed(),"Order text is not displayed");
        System.out.println(overviewPage.getLoadedText());
        getWindowManager().switchToNewTab();
        checkoutComplete.setBackHomeButton();

    }
}
