package Rahulshettyacademy.tests.pageobjects;

import Rahulshettyacademy.tests.Testcomponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class errorvalidation extends BaseTest {

        @Test
        public void StandalonedTest() throws IOException, InterruptedException {

        String productname = "ADIDAS ORIGINAL";
        productCatalogue productCatalogue = landingpage.loginapplication("drdoom@yopmail.com","Tet@123");
        Assert.assertEquals("Incorrect email or pas@@sword.",landingpage.getErrorMessage());


































    }

         private static boolean isElementVisible(WebDriver driver, WebElement element) {
        return false;
    }
}
