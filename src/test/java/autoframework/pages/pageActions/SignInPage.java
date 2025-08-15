package autoframework.pages.pageActions;
import autoframework.base.BasePage;
import autoframework.pages.pageObjects.SigInPageObjects;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.LogUtils;
import utils.PropertiesUtils;
import java.util.logging.Logger;

public class SignInPage extends BasePage {
    public SigInPageObjects siginPageObjects;

    public SignInPage(WebDriver driver){
        super(driver);
        siginPageObjects = new SigInPageObjects(driver);

    }

    public void navigateToPage(){
        LogUtils.warn("Navigate");
        driver.navigate().to(PropertiesUtils.get("URL"));
        siginPageObjects.searchBox.sendKeys("Automation Tool");
    }
}
