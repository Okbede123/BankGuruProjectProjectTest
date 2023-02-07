package testcase;

import actions.pageobject.EditAccountPageObject;
import actions.pageobject.LoginPageObject;
import actions.pageobject.ManagerHomePage;
import actions.pageobject.PageGeneralManager;
import cores.commons.BaseTest;
import cores.commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EditAccountAndCheck extends BaseTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    ManagerHomePage managerHomePage;
    EditAccountPageObject editAccountPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browser){
        driver = openBrowser(browser,"https://demo.guru99.com/v4/");
        loginPageObject = PageGeneralManager.openLoginPage(driver);
       managerHomePage = loginPageObject.inputUserNamePassAndLogin(GlobalConstant.USER_NAME,GlobalConstant.PASSWORD,"LOGIN");
       editAccountPageObject = managerHomePage.openMenuSubNavigation().goToEditAccountMenuSubNav("Edit Account");
    }

    @Test
    public void TC_01_EditAccountAndCheck(){
        editAccountPageObject.inputAccountNoAndSubmitAndAcceptAlert("");
    }
}
