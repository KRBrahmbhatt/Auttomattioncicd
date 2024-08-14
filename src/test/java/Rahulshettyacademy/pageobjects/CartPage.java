package Rahulshettyacademy.pageobjects;

import Rahulshettyacademy.AbstractComponent.abstractcomponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends abstractcomponent {

    WebDriver driver;
    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;
    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


        public Boolean verifyproductDisplay(String productName)
        {
            Boolean match = cartProducts.stream().anyMatch(c -> c.getText().equalsIgnoreCase(productName));
            return match;
        }

        public CheckoutPage goToCheckout()
        {
            checkoutEle.click();
            return new CheckoutPage(driver);

        }



}