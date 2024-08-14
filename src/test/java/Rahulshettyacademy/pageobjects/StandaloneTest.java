package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

public class StandaloneTest {
    public static void main(String[] args) throws InterruptedException {
        String productname = "ADIDAS ORIGINAL";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        landingpage landingpage = new landingpage(driver);
        landingpage.goTo();
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
        driver.quit();































    }

         private static boolean isElementVisible(WebDriver driver, WebElement element) {
        return false;
    }
}
