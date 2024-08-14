package Rahulshettyacademy.pageobjects;

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

        public productCatalogue loginapplication(String email , String password1)
        {
            useremail.sendKeys(email);
            password.sendKeys(password1);
            submitbutton.click();
            productCatalogue productCatalogue = new productCatalogue(driver);
            return productCatalogue;

        }

        public void goTo()
        {
            driver.get("https://rahulshettyacademy.com/client");
        }

}