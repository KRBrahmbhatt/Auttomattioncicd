package tests;

//import Rahulshettyacademy.tests.AbstractComponent.abstractcomponent;
import Rahulshettyacademy.AbstractComponent.abstractcomponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productCatalogue extends abstractcomponent {
            WebDriver driver;
            public productCatalogue(WebDriver driver)
            {
                super(driver);
                this.driver=driver;
                PageFactory.initElements(driver,this);
            }

        //pagefactory
        @FindBy(css =".mb-3")
        List<WebElement> pro;
          @FindBy(css =".ng-animating")
                 WebElement dis;
           By products1 =  By.cssSelector(".mb-3");
           By addToCart = By.cssSelector(".card-body button:last-of-type");
             By toastmessage =By.id("toast-container");
            public List<WebElement> getProductLiist()
            {

                waitForElementTOAppear(products1);
                return pro;
            }

            public WebElement getProductByName(String productname)
            {
                WebElement prod = getProductLiist().stream().filter(s ->
                        s.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
                return prod;
            }

            public void addProductToCart(String productname) throws InterruptedException {
                   WebElement prod =getProductByName (productname);
                prod.findElement(addToCart).click();
                waitForElementTOAppear(toastmessage);
                waitForELementToDisappear(dis);


            }


}