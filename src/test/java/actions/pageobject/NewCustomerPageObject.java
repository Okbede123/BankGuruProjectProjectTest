package actions.pageobject;

import interfaceUI.BaseUIBankGuru;
import interfaceUI.NewCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class NewCustomerPageObject extends MenuSubNavigation {
    WebDriver driver;
    public NewCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void inputInformationAddressCustomer(String valueToSend, String typeValue){

        if(getAttribute(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,"type","Date of Birth").contains("date")){
            removeAttribute(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,"type","Date of Birth");
        }
        sendKeysToElement(BaseUIBankGuru.INPUT_INFORMATION_WITH_TD,valueToSend,typeValue);
    }

    public void inputInformationAddressCustomer(String valueToSend){
        sendKeysToElement(NewCustomerPageUI.INPUT_ADDRESS,valueToSend);
    }

    public void clickToButtonCreateCustomer(String typeValue){
        clickToElements(BaseUIBankGuru.BUTTON_TYPE,typeValue);
    }


    public String getTextVerifyCustomerTitle(){
        return getText(NewCustomerPageUI.VERIFY_CREATE_CUSTOMER_SUCCESSFULLY);
    }

    public String getTextVerifyField(String field){
        return getText(NewCustomerPageUI.VERIFY_FIELD,field);
    }

}
