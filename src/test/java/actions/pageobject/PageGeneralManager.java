package actions.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGeneralManager {

    public static LoginPageObject openLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject openRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static ManagerHomePage openManagerHomePage(WebDriver driver){
        return new ManagerHomePage(driver);
    }
    public static NewCustomerPageObject openNewCustomerPage(WebDriver driver){
        return new NewCustomerPageObject(driver);
    }
}
