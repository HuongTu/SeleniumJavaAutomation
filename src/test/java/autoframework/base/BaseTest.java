package autoframework.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    public PageManager pageManager;
    DriverManager driverManager;

    // Extent report objects
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void setUpTestSuite() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method) {
        // Create a new test in the report for each method
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);

        // Setup WebDriver and PageManager
        driverManager = new DriverManager();
        driver = DriverManager.getDriver();
        pageManager = new PageManager(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(ITestResult result) {
        ExtentTest currentTest = test.get();

        if (result.getStatus() == ITestResult.FAILURE) {
            currentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            currentTest.skip("Test Skipped");
        } else {
            currentTest.pass("Test Passed");
        }

        // Quit driver after each test
        driverManager.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        // Flush report after all tests are done
        extent.flush();
    }

    // Helper to get the current test instance anywhere
    protected ExtentTest getTest() {
        return test.get();
    }
}
