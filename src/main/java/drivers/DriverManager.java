package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.LogUtils;
import utils.PropertiesUtils;

public class DriverManager {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            driver = initializeDriver();
            driverThreadLocal.set(driver);
        }
        return driver;
    }

    public static WebDriver initializeDriver() {
        String browserType = System.getProperty("browser", PropertiesUtils.get("default.browser"));
        WebDriver driver;
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver((ChromeOptions) BrowserConfig.getOptions("chrome"));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver((FirefoxOptions) BrowserConfig.getOptions("firefox"));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver((EdgeOptions) BrowserConfig.getOptions("edge"));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

       // driver.manage().window().maximize();
        driverThreadLocal.set(driver);
        LogUtils.warn("Driver already initialized for this thread.");
        return driver;
    }

    public void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
