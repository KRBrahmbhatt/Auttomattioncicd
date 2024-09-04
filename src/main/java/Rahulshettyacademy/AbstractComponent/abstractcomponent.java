package Rahulshettyacademy.AbstractComponent;

//import Rahulshettyacademy.tests.pageobjects.CartPage;
//import Rahulshettyacademy.tests.pageobjects.Orderpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CartPage;

import java.time.Duration;

public class abstractcomponent {
    WebDriver driver;
    public abstractcomponent(WebDriver driver) {
              this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (css = "[routerlink*=\"cart\"]")
            WebElement cartheader;
    @FindBy (css = "[routerlink*=\"myorders\"]")
    WebElement orderheader;



    public void waitForElementTOAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((ExpectedConditions.visibilityOfElementLocated(findBy)));
    }
    public void waitForElementTOAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }
    public CartPage goTOCartPage() {

            cartheader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    public Orderpage goTOOrdersPage() {

        orderheader.click();
        Orderpage orderPage = new Orderpage(driver);
        return orderPage;
    }

    public void waitForELementToDisappear(WebElement ele) throws InterruptedException
    {
        Thread.sleep(1000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.invisibilityOf(ele));
    }
}
