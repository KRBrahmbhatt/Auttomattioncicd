package tests;

import Rahulshettyacademy.AbstractComponent.abstractcomponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage  extends abstractcomponent {
            WebDriver driver;
            public landingpage(WebDriver driver)
            {
                super(driver);
                this.driver=driver;
                PageFactory.initElements(driver,this);
            }

        //pagefactory
        @FindBy(id = "userEmail")
        WebElement useremail;
        @FindBy(id = "userPassword")
        WebElement password;
        @FindBy(id="login")
        WebElement submitbutton;
        @FindBy(css = "[class*='flyInOut']")
        WebElement errorMessage;

        public productCatalogue loginapplication(String email , String password1)
        {
            System.out.println("INNNNNNNNNNNN");
            useremail.sendKeys(email);
            password.sendKeys(password1);
            submitbutton.click();
            productCatalogue productCatalogue = new productCatalogue(driver);
            return productCatalogue;

        }
        public String getErrorMessage()
        {
            waitForElementTOAppear(errorMessage);
            return errorMessage.getText();
        }

        public void goTo()
        {
            driver.get("https://rahulshettyacademy.com/client");
        }

}