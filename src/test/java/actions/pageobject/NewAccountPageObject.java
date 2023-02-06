package actions.pageobject;

import interfaceUI.BaseUIBankGuru;
import interfaceUI.NewAccountPageUI;
import org.openqa.selenium.WebDriver;

public class NewAccountPageObject extends MenuSubNavigation {
    WebDriver driver;
    public NewAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputAddNewAccountForm(String idCustomer,String accountType,String valueInitialDeposit){
        sendKeysToElement(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,idCustomer,"Customer id");
        selectItem(NewAccountPageUI.SELECT_ACCOUNT_TYPE,accountType);
        sendKeysToElement(NewAccountPageUI.INITIAL_DEPOSIT,valueInitialDeposit);
    }

}
