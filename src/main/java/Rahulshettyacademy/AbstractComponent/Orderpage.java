package Rahulshettyacademy.AbstractComponent;

//import Rahulshettyacademy.tests.AbstractComponent.abstractcomponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Orderpage extends abstractcomponent {

    WebDriver driver;
    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productNames;
    public Orderpage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


        public Boolean verifyOrderDisplay(String productname)
        {
            Boolean match = productNames.stream().anyMatch(c -> c.getText().equalsIgnoreCase(productname));
            return match;
        }





}
