package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    private By cartDisplayed = By.cssSelector(".shopping_cart_link");
    private By products =By.className("inventory_item");


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
    public boolean isCartDisplayed() {
        return driver.findElement(cartDisplayed).isDisplayed();
    }
    public int numOfCardProducts(){
        return driver.findElements(products).size();
    }
}
