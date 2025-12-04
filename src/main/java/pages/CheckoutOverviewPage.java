package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private WebDriver driver;

    By finishBtn = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderCompletePage finishOrder() {
        driver.findElement(finishBtn).click();
        return new OrderCompletePage(driver);
    }
}
