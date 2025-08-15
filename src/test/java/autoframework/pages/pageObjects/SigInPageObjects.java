package autoframework.pages.pageObjects;

import autoframework.base.BasePage;
import autoframework.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigInPageObjects extends BasePage {

    @FindBy(name = "q")
    public WebElement searchBox;

    public SigInPageObjects(WebDriver driver){
        super(driver);


    }
}
