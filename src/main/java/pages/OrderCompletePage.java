package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletePage {

    private WebDriver driver;

    By successMsg = By.cssSelector(".complete-header");

    public OrderCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderSuccess() {
        return driver.findElement(successMsg).isDisplayed();
    }
}
