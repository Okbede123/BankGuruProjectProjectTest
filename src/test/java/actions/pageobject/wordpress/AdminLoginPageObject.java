package actions.pageobject.wordpress;

import cores.commons.BasePage;
import interfaceUI.wordpress.AdminLoginPageUI;
import interfaceUI.wordpress.AdminPostPageUI;
import org.openqa.selenium.WebDriver;

public class AdminLoginPageObject extends NavigationMenuPageObject {
    WebDriver driver;
    public AdminLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AdminDashboardPageObject sendUserNamePassAndLogin(String userName,String password){
        sendKeysToElement(AdminLoginPageUI.USER_NAME,userName);
        sendKeysToElement(AdminLoginPageUI.PASSWORD,password);
        clickToElements(AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneralManager.openAdminDashBoard(driver);
    }
}
