package actions.pageobject.bankguru;

import interfaceUI.bankguru.BaseUIBankGuru;
import interfaceUI.bankguru.NewCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class EditCustomerPageObject extends MenuSubNavigation {
    WebDriver driver;
    public EditCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputCustomerIdandSubmit(String id){
        sendKeysToElement(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,id,"Customer ID");
        clickToElements(BaseUIBankGuru.BUTTON_TYPE,"submit");
    }

    public void inputInformationEditCustomer(String valueToSend,String typeValue){

        if(getAttribute(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,"type","Date of Birth").contains("date")){
            removeAttribute(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,"type","Date of Birth");
        }
        sendKeysToElement(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,valueToSend,typeValue);
    }

    public void inputInformationAddressCustomerPageEdit(String valueToSend){
        sendKeysToElement(NewCustomerPageUI.INPUT_ADDRESS,valueToSend);
    }

}
