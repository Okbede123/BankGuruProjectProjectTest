package actions.pageobject;

import actions.pageobject.bankguru.MenuSubNavigation;

import interfaceUI.bankguru.BaseUIBankGuru;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPageObject extends MenuSubNavigation {
    WebDriver driver;

    public DeleteAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputAccountNoAndSubmit(String accountNo){
        sendKeysToElement(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,accountNo,"Account No");
        clickToElements(BaseUIBankGuru.BUTTON_TYPE,"submit");
        waitAlertPresentAndAccept();
    }
}
