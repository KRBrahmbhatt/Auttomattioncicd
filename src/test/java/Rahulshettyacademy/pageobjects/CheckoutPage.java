package Rahulshettyacademy.pageobjects;

import Rahulshettyacademy.AbstractComponent.abstractcomponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends abstractcomponent {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(css = ".action__submit")
    WebElement submit;
    @FindBy(css = "[placeholder=\"Select Country\"]")
    WebElement country;
    @FindBy(xpath = "//button[contains(@class,\"ta-item\")][2]")
    WebElement selectcountry;
     By result=By.cssSelector(".ta-results");

    public void selectCountry(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        waitForElementTOAppear(By.cssSelector(".ta-results"));
        selectcountry.click();
    }
    public Confirmationpage submitOrder()
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submit));
        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("window.scrollBy(0,1000)", element);
        element.click();
         return new Confirmationpage(driver);
    }
}

