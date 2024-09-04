package pageobjects;

//import Rahulshettyacademy.tests.AbstractComponent.abstractcomponent;
import Rahulshettyacademy.AbstractComponent.abstractcomponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmationpage extends abstractcomponent {
    WebDriver driver;

    public Confirmationpage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    @FindBy (css = ".hero-primary")
    WebElement confirmationMessage;
    public String getConfirmationMessage()
    {
        return confirmationMessage.getText();
    }
}
