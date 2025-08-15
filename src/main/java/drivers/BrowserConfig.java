package drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.PropertiesUtils;

public class BrowserConfig {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        PropertiesUtils.getList("chrome.arguments").forEach(options::addArguments);
        if (Boolean.parseBoolean(PropertiesUtils.get("headless"))) {
            options.addArguments("--headless=new");
        }
        return options;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        PropertiesUtils.getList("firefox.arguments").forEach(options::addArguments);
        if (Boolean.parseBoolean(PropertiesUtils.get("headless"))) {
            options.addArguments("-headless");
        }
        return options;
    }

    public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        PropertiesUtils.getList("edge.arguments").forEach(options::addArguments);
        if (Boolean.parseBoolean(PropertiesUtils.get("headless"))) {
            options.addArguments("--headless");
        }
        return options;
    }

    public static Object getOptions(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                return getChromeOptions();
            case "firefox":
                return getFirefoxOptions();
            case "edge":
                return getEdgeOptions();
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }
}
