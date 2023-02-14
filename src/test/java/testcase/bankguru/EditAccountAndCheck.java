package testcase.bankguru;

import actions.pageobject.bankguru.EditAccountPageObject;
import actions.pageobject.bankguru.LoginPageObject;
import actions.pageobject.bankguru.ManagerHomePage;
import actions.pageobject.bankguru.PageGeneralManager;
import cores.commons.BaseTest;
import cores.commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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
}
