package com.capgemini.test;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.capgemini.utils.Screenshots;

public class BaseReport {

    protected static ExtentReports extent;
    protected static ExtentSparkReporter spark;
    protected ExtentTest parentTest; // Class-level node
    protected ExtentTest test;       // Method-level node
    protected WebDriver driver;      // Make sure subclasses initialize this

    @BeforeSuite
    public void setUpReport() {
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + 
        													"./Extent Reports/AutomationReport.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("TNSTC Automation Suite");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeClass
    public void setUpClass() {
        parentTest = extent.createTest(getClass().getSimpleName());
    }

    @BeforeMethod
    public void setUpMethod(Method method) {
        test = parentTest.createNode(method.getName());
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = Screenshots.takeScreenShot(driver, result.getName());
            test.fail(result.getThrowable());
            test.fail("<b>Screenshot:</b><br><img src='" + screenshotPath + 
            			"' style='width:90%; height:auto;'>");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getThrowable());
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }

    
    public void generateReportWithScreenshot(String stepDescription, String screenshotPath) {
        test.info(stepDescription + "<br><img src='" + screenshotPath + 
        			"' style='width:90%; height:auto;'/>");
    }

}
