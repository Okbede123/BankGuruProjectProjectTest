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

    public static EditCustomerPageObject openEditCustomerPage(WebDriver driver){
        return new EditCustomerPageObject(driver);
    }

    public static NewAccountPageObject openNewAccountPage(WebDriver driver){
        return new NewAccountPageObject(driver);
    }

    public static EditAccountPageObject openEditAccountPage(WebDriver driver){
        return new EditAccountPageObject(driver);
    }

    public static DeleteAccountPageObject openDeleteAccountPage(WebDriver driver){
        return new DeleteAccountPageObject(driver);
    }
}
