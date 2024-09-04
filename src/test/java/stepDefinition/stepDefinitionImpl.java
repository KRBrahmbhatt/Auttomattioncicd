package stepDefinition;

import Testcomponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.Confirmationpage;
import tests.landingpage;
import tests.productCatalogue;

import java.io.IOException;
import java.util.List;

//import java.io.IOException;

public class stepDefinitionImpl extends BaseTest {
    public landingpage landingpage;
    public productCatalogue productCatalogue;
    public  Confirmationpage confirmationpage;
    @Given("I landed on Ecommerce Page")
    public void Landed_Ecommerce_Page() throws IOException {
          landingpage = launchApplication();
    }

    @Given ("^logged in with username (.+) and password (.+)$")
    public void loggend_in_username_and_pass(String username , String password)
    {
         productCatalogue = landingpage.loginapplication(username,password);
    }

    @When("^I add product (.+) to cart$")
    public void add_product_to_cart(String proname) throws InterruptedException {
        List<WebElement> pro = productCatalogue.getProductLiist();
        productCatalogue.addProductToCart(proname);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String proname) throws InterruptedException {

        CartPage cartPage = productCatalogue.goTOCartPage();
        Boolean match = cartPage.verifyproductDisplay(proname);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
         confirmationpage = checkoutPage.submitOrder();
    }
    @Then("{string} confirmation message is displayed on confirmationpage")
    public void message_is_displayed_on_confirmationpage(String string)
    {
        String confirmmessage = confirmationpage.getConfirmationMessage();
        Assert.assertTrue(confirmmessage.equalsIgnoreCase(string));
        driver.close();
    }
    @Then("{string} message is displayed")
    public void Somthing_message_is_displayed(String stri)
    {
        Assert.assertEquals(stri, landingpage.getErrorMessage());
        driver.close();
    }


}
