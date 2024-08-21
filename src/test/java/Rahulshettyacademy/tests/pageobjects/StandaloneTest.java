package Rahulshettyacademy.tests.pageobjects;

import Rahulshettyacademy.tests.Testcomponents.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class StandaloneTest extends BaseTest {

        @Test
        public void StandalonedTest() throws IOException, InterruptedException {

        String productname = "ADIDAS ORIGINAL";
        productCatalogue productCatalogue = landingpage.loginapplication("drdoom@yopmail.com","Test@123");

        List<WebElement>   pro  =productCatalogue.getProductLiist();
        productCatalogue.addProductToCart(productname);
        CartPage cartPage= productCatalogue.goTOCartPage();
        Boolean match = cartPage.verifyproductDisplay(productname);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage= cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        Confirmationpage confirmationpage = checkoutPage.submitOrder();
        String confirmmessage = confirmationpage.getConfirmationMessage();
        Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

































    }

         private static boolean isElementVisible(WebDriver driver, WebElement element) {
        return false;
    }
}
