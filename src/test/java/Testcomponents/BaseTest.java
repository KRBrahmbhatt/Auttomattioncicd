package Testcomponents;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import tests.landingpage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
     public landingpage landingpage;
    public WebDriver initilizeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\Kaushal\\IdeaProjects\\SeleniumFrameworkDesign\\src\\main\\java\\resources\\GlobalData.properties");
        prop.load(file);
        String browsername =System.getProperty("browser")!=null ?  System.getProperty("browser") :prop.getProperty("browser");
          // String browsername = prop.getProperty("browser");

           if (browsername.contains("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            if (browsername.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));

    } else if (browsername.equalsIgnoreCase("firefox")) {
               driver = new FirefoxDriver();
               
           } else if (browsername.equalsIgnoreCase("edge")) {
               driver = new EdgeDriver();
           }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               return driver;
           }
            @BeforeMethod(alwaysRun = true)
           public landingpage launchApplication() throws IOException {
                driver = initilizeDriver();
                landingpage = new landingpage(driver);
               landingpage.goTo();
               return landingpage;


           }
    public List<HashMap<String,String>> getJsonDataMap(String filepath) throws IOException {
        String jsoncontent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {


        });
        return data;
    }
    public String getScreenshot(String testcaseSS,WebDriver driver  ) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+testcaseSS+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//"+testcaseSS+".png";

    }
           @AfterMethod(alwaysRun = true)
    public void tearDown()
           {
               driver.close();
           }
    }
