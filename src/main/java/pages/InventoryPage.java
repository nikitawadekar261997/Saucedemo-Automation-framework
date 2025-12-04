package pages;

import org.openqa.selenium.*;
import java.util.*;

public class InventoryPage {

    private WebDriver driver;

    By products = By.cssSelector(".inventory_item");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(products);
    }

    public void addRandomThreeItems() {
        List<WebElement> items = getAllProducts();
        Collections.shuffle(items);
        items.stream().limit(3).forEach(item -> {
            item.findElement(By.tagName("button")).click();
        });
    }

    public CartPage goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        return new CartPage(driver);
    }
}
