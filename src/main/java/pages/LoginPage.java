package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userName = By.id("user-name");
    private By Password = By.id("password");
    private By login = By.id("login-button");
    private By invalidlogin = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username){
        driver.findElement(userName).sendKeys(username);

    }
    public void enterPassword(String password){
        driver.findElement(Password).sendKeys(password);

    }
    public String getTextInvalidLogin(){
        return driver.findElement(invalidlogin).getText();
    }
    public InventoryPage clickLogin(){
        driver.findElement(login).click();
        return new InventoryPage(driver);
    }


}
