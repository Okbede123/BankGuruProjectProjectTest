package testcase;

import actions.pageobject.*;
import actions.pageobject.bankguru.*;
import cores.commons.BasePage;
import cores.commons.BaseTest;
import cores.commons.GlobalConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testcase.bankguru.CreateCustomerAndCheck;

import java.time.Duration;

public class DeleteAccount extends BaseTest {
     WebDriver driver;
     LoginPageObject loginPageObject;
     
    ManagerHomePage managerHomePage;
    NewCustomerPageObject newCustomerPageObject;
    EditCustomerPageObject editCustomerPageObject;
    NewAccountPageObject newAccountPageObject;
    DeleteAccountPageObject deleteAccountPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browser){
        driver = openBrowser(browser,"https://demo.guru99.com/v4/");
        loginPageObject = PageGeneralManager.openLoginPage(driver);
    }

    @Test
    public void TC_AddNewAccountAndCheck(){
        managerHomePage = loginPageObject.inputUserNamePassAndLogin(GlobalConstant.USER_NAME,GlobalConstant.PASSWORD,"LOGIN");
        deleteAccountPageObject = managerHomePage.openMenuSubNavigation().goToDeleteAccountMenuSubNav("Delete Account");
        deleteAccountPageObject.inputAccountNoAndSubmit(CreateCustomerAndCheck.accountID);
    }
}
