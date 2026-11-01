package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DataDriven;

public class InventoryTest extends BaseTest {
    @Test
    public void inventoryPageTest() {
        String username = DataDriven.jsonReader("validLogin", "username");
        String password = DataDriven.jsonReader("validLogin", "password");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        InventoryPage inventoryPage = loginPage.clickLogin();

        Assert.assertEquals(inventoryPage.getPageTitle(), "Swag Labs");

        Assert.assertTrue(inventoryPage.isCartDisplayed());

        Assert.assertEquals(inventoryPage.numOfCardProducts(), 6);
    }
}
