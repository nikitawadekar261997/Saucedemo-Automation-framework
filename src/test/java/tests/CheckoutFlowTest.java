package tests;

import base.BaseTest;
import base.DriverFactory;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void completeCheckout() throws InterruptedException {

        LoginPage login = new LoginPage(DriverFactory.getDriver());
 
        InventoryPage inventory = login.login("standard_user", "secret_sauce");
      
        inventory.addRandomThreeItems();
        
        CartPage cart = inventory.goToCart();
    
        CheckoutPage checkout = cart.checkout();

        CheckoutOverviewPage overview = checkout.enterDetails("Nikita", "W", "411001");

        OrderCompletePage complete = overview.finishOrder();

        Assert.assertTrue(complete.isOrderSuccess(), "Order not completed!");
    }
}
