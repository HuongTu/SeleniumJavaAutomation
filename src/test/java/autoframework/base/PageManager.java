package autoframework.base;

import autoframework.pages.pageActions.SignInPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    WebDriver driver;

    public SignInPage signInPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage getSignInPage(){
        if (signInPage == null) {
            signInPage = new SignInPage(driver);
        }
        return signInPage;
    }
}
