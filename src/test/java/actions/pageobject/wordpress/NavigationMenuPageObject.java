package actions.pageobject.wordpress;

import cores.commons.BasePage;
import interfaceUI.wordpress.AdminDashboardPageUI;
import org.openqa.selenium.WebDriver;

public class NavigationMenuPageObject extends BasePage {
    WebDriver driver;

    public NavigationMenuPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AdminPostPageObject clickToPostMenuNavigation(String menu){
        try {
            System.out.println("test1");
            moveToElement(AdminDashboardPageUI.NAVIGATION_MENU,menu);
            clickToElements(AdminDashboardPageUI.NAVIGATION_MENU,menu);
            return PageGeneralManager.openAdminPostPage(driver);
        }catch (RuntimeException e){
            System.out.println("test2");
            return null;
        }
    }
}
