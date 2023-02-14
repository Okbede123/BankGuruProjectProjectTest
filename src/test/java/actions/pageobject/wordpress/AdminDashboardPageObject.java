package actions.pageobject.wordpress;

import cores.commons.BasePage;
import interfaceUI.wordpress.AdminDashboardPageUI;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPageObject extends NavigationMenuPageObject {
    WebDriver driver;
    public AdminDashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AdminPostPageObject clickToPostMyDashBoard(String menu){
        moveToElement(AdminDashboardPageUI.NAVIGATION_MENU,menu);
        clickToElements(AdminDashboardPageUI.NAVIGATION_MENU,menu);
        return PageGeneralManager.openAdminPostPage(driver);
    }

}
