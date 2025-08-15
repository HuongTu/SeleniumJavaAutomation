package autoframework.testcases;

import autoframework.base.BasePage;
import autoframework.base.BaseTest;
import autoframework.base.PageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;
import utils.LogUtils;

public class SignIn_Successfully extends BaseTest {

    @Test
    public void loginToPageSuccessfully() {
        pageManager.getSignInPage().navigateToPage();
        getTest().pass("Navigated to Google");
    }


}
