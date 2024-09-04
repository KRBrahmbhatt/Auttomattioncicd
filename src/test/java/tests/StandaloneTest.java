package tests;

import Rahulshettyacademy.AbstractComponent.Orderpage;
//import Rahulshettyacademy.tests.Testcomponents.BaseTest;
import Testcomponents.BaseTest;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.Confirmationpage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class StandaloneTest extends BaseTest {
        String productname = "ADIDAS ORIGINAL";
        @Test(dataProvider = "getData",groups = {"purchase"})
        public void StandalonedTest(HashMap<String,String> input ) throws IOException, InterruptedException {


                productCatalogue productCatalogue = landingpage.loginapplication(input.get("email"), input.get("password"));

                List<WebElement> pro = productCatalogue.getProductLiist();
                productCatalogue.addProductToCart(input.get("productname"));
                CartPage cartPage = productCatalogue.goTOCartPage();
                Boolean match = cartPage.verifyproductDisplay(input.get("productname"));
                Assert.assertTrue(match);
                CheckoutPage checkoutPage = cartPage.goToCheckout();
                checkoutPage.selectCountry("india");
                Confirmationpage confirmationpage = checkoutPage.submitOrder();
                String confirmmessage = confirmationpage.getConfirmationMessage();
                Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        }

        @Test(dependsOnMethods = {"StandalonedTest"})
        public void orderHistoryTest()
        {
                productCatalogue productCatalogue = landingpage.loginapplication("drdoom@yopmail.com", "Test@123");
               Orderpage orderPage = productCatalogue.goTOOrdersPage();
                orderPage.verifyOrderDisplay(productname);
                Assert.assertTrue(orderPage.verifyOrderDisplay(productname));



        }

        public String getScreenshot(String testcaseSS) throws IOException {
              TakesScreenshot ts = (TakesScreenshot)driver;
               File source = ts.getScreenshotAs(OutputType.FILE);
               File file = new File(System.getProperty("user.dir")+"//reports//"+testcaseSS+".png");
                FileUtils.copyFile(source,file);
                return System.getProperty("user.dir")+"//reports//"+testcaseSS+".png";

        }
        @DataProvider
        public Object[][] getData() throws IOException {
//                HashMap<String, String> map = new HashMap<String, String>();
//                map.put("email","drdoom@yopmail.com");
//                map.put("password","Test@123");
//                map.put("productname","ADIDAS ORIGINAL");
//
//                HashMap<String, String> map1 = new HashMap<String, String>();
//                map1.put("email","shetty@gmail.com");
//                map1.put("password","Iamking@000");
//                map1.put("productname","ZARA COAT 3");

            List<HashMap<String, String>> data = getJsonDataMap("C:\\Users\\Kaushal\\IdeaProjects\\SeleniumFrameworkDesign\\src\\test\\java\\Data\\purchaseorder.json");
            return new Object [][]{{data.get(0)},{data.get(1)}};
        }

//        @DataProvider
//        public Object[][] getData()
//        {
//                return new Object[][] {{},{}};
//
//        }




































       //  private static boolean isElementVisible(WebDriver driver, WebElement element) {
     //   return false;
    }

