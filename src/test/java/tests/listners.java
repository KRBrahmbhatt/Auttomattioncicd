package tests;

//import Rahulshettyacademy.resources.ExtentreporterNg;
import Testcomponents.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentreporterNg;

import java.io.IOException;

public class listners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent= ExtentreporterNg.getReportObject();
    ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();//threadsafe

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
       test = extent.createTest(result.getMethod().getMethodName());
       extenttest.set(test);//unique thread id (errorvalidationtest)-test//so now this is not overridden
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        extenttest.get().log(Status.PASS,"Test is Passed");

        }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        extenttest.get().fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
        String filepath = null;

        try {
            filepath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extenttest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
        //Screenshot  , Attached to the report
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }
}
