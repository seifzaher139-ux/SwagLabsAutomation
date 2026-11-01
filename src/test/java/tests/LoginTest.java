package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.LoginPage;
import utils.DataDriven;
public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        String username = DataDriven.jsonReader("validLogin", "username");
        String password = DataDriven.jsonReader("validLogin", "password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory.html"));
    }
    @Test
    public void invalidLoginTest(){
        String username1 = DataDriven.jsonReader("invalidLogin", "username");
        String password1 = DataDriven.jsonReader("invalidLogin", "password");
        LoginPage loginPage =new LoginPage(driver);
        loginPage.enterPassword(password1);
        loginPage.enterUserName(username1);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getTextInvalidLogin().contains("Username and password do not match"));
    }
    @Test
    public void invalidLoginTestWithoutPassword(){
        String username2 = DataDriven.jsonReader("invalidLoginWithoutPassword", "username");
        String password2 = DataDriven.jsonReader("invalidLoginWithoutPassword", "password");
        LoginPage loginPage =new LoginPage(driver);
        loginPage.enterPassword(password2);
        loginPage.enterUserName(username2);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getTextInvalidLogin().contains("Password is required"));
    }
}
