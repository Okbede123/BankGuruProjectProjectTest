package actions.pageobject;

import cores.commons.BasePage;
import interfaceUI.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ManagerHomePage inputUserNamePassAndLogin(String user,String pass,String button){
        sendKeysToElement(LoginPageUI.INPUT_INFORMATION,user,"UserID");
        sendKeysToElement(LoginPageUI.INPUT_INFORMATION,pass,"Password");
        clickToElements(LoginPageUI.BUTTON_DYNAMIC,button);
        return PageGeneralManager.openManagerHomePage(driver);
    }

    public ManagerHomePage inputInformation(){
        sendKeysToElement(LoginPageUI.INPUT_INFORMATION,"mngr476454","UserID");
        sendKeysToElement(LoginPageUI.INPUT_INFORMATION,"YjepAtE","Password");
        return PageGeneralManager.openManagerHomePage(driver);
    }
}
