package Rahulshettyacademy.tests.Testcomponents;

import Rahulshettyacademy.tests.pageobjects.landingpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
     public landingpage landingpage;
    public WebDriver initilizeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Kaushal\\IdeaProjects\\SeleniumFrameworkDesign\\src\\main\\java\\Rahulshettyacademy\\resources\\GlobalData.properties");
        prop.load(file);
           String browsername = prop.getProperty("browser");

           if (browsername.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();

    } else if (browsername.equalsIgnoreCase("firefox")) {
               
           } else if (browsername.equalsIgnoreCase("edge")) {
               driver = new EdgeDriver();
           }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               return driver;
           }
            @BeforeMethod
           public landingpage launchApplication() throws IOException {
                driver = initilizeDriver();
                landingpage = new landingpage(driver);
               landingpage.goTo();
               return landingpage;


           }
           @AfterMethod
    public void tearDown()
           {
               driver.close();
           }
    }
