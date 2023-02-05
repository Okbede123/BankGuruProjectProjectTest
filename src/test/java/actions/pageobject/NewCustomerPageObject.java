package actions.pageobject;

import cores.commons.BasePage;
import interfaceUI.NewCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class NewCustomerPageObject extends BasePage {
    WebDriver driver;
    public NewCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void inputInformationCustomer(String valueToSend,String typeValue){

        if(getNameUrl().contains("google_vignette")){
            goToURl("https://demo.guru99.com/v4/manager/addcustomerpage.php");
        }
        if(getAttribute(NewCustomerPageUI.INPUT_INFORMATION_CUSTOMER,"type","Date of Birth").contains("date") && !getNameUrl().contains("google_vignette")){
            removeAttribute(NewCustomerPageUI.INPUT_INFORMATION_CUSTOMER,"type","Date of Birth");
        }
        sendKeysToElement(NewCustomerPageUI.INPUT_INFORMATION_CUSTOMER,valueToSend,typeValue);
    }

    public void inputInformationCustomer(String valueToSend){
        sendKeysToElement(NewCustomerPageUI.INPUT_ADDRESS,valueToSend);
    }

    public void clickToButtonCreateCustomer(String typeValue){
        clickToElements(NewCustomerPageUI.BUTTONS,typeValue);
    }


    public String getTextVerifyCustomerTitle(){
        return getText(NewCustomerPageUI.VERIFY_CREATE_CUSTOMER_SUCCESSFULLY);
    }

    public String getTextVerifyField(String field,String valueExpected){
        return getText(NewCustomerPageUI.VERIFY_FIELD,field,valueExpected);
    }

}
