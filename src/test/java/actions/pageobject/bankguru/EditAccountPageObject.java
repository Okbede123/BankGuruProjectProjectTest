package actions.pageobject.bankguru;

import interfaceUI.BaseUIBankGuru;
import org.openqa.selenium.WebDriver;

public class EditAccountPageObject extends MenuSubNavigation {
    WebDriver driver;

    public EditAccountPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputAccountNoAndSubmitAndAcceptAlert(String accountNo){
        sendKeysToElement(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,accountNo);
        clickToElements(BaseUIBankGuru.BUTTON_TYPE,"submit");
        waitAlertPresentAndGetText();
    }
}
