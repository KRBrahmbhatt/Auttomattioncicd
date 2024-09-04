package tests;

//import Rahulshettyacademy.tests.Testcomponents.BaseTest;
import Testcomponents.BaseTest;
import Testcomponents.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.CartPage;

import java.io.IOException;
import java.util.List;

public class errorvalidation extends BaseTest {

    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void loginerrorValidation() throws IOException, InterruptedException {

        String productname = "ADIDAS ORIGINAL";
        productCatalogue productCatalogue = landingpage.loginapplication("drdoom@yopmail.com", "Tet@123");
        Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
    }

        @Test
        public void Producterrorvalidation () throws IOException, InterruptedException {

            String productname = "ADIDAS ORIGINAL";
            productCatalogue productCatalogue = landingpage.loginapplication("drdoom@yopmail.com", "Test@123");

            List<WebElement> pro = productCatalogue.getProductLiist();
            productCatalogue.addProductToCart(productname);
            CartPage cartPage = productCatalogue.goTOCartPage();
            Boolean match = cartPage.verifyproductDisplay("ADIDAS ORIGINAL");
            Assert.assertTrue(match);


        }

       // private static boolean isElementVisible (WebDriver driver, WebElement element){
       //     return false;
        }

