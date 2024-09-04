package pageobjects;

//import Rahulshettyacademy.tests.AbstractComponent.abstractcomponent;
import Rahulshettyacademy.AbstractComponent.abstractcomponent;
import org.openqa.selenium.*;
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
    By result = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        // Scroll the country input element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", country);

        // Send the country name to the input field
        country.sendKeys(countryName);

        // Explicit wait with increased timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        // Scroll the selectcountry element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectcountry);

        // Wait for the element to be clickable
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(selectcountry));

        // Click the element
        try {
            clickableElement.click();
        } catch (ElementClickInterceptedException e) {
            // Fallback to JavaScript click if intercepted
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectcountry);
        }
    }




//    public void selectCountry(String countryName) {
//        Actions a = new Actions(driver);
//        a.sendKeys(country, countryName).build().perform();
//        waitForElementTOAppear(By.cssSelector(".ta-results"));
//        selectcountry.click();
//    }

    public Confirmationpage submitOrder() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submit));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isElementClickable = false;
        do {

            js.executeScript("arguments[0].scrollIntoView(true);", element);


            element = wait.until(ExpectedConditions.elementToBeClickable(submit));

            // Try to click the element if it's clickable
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
                isElementClickable = true;
            } else {
                // Scroll down the page
                js.executeScript("window.scrollBy(0,1000)");
            }
        } while (!isElementClickable);



         return new Confirmationpage(driver);



    }
}




