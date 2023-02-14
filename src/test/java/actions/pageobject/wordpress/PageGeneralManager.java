package actions.pageobject.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneralManager {

    public static AdminDashboardPageObject openAdminDashBoard(WebDriver driver){
        return new AdminDashboardPageObject(driver);
    }

    public static AdminLoginPageObject openAdminLogin(WebDriver driver){
        return new AdminLoginPageObject(driver);
    }

    public static AdminPostPageObject openAdminPostPage(WebDriver driver){
        return new AdminPostPageObject(driver);
    }

    public static UserHomePageObject openUserHome(WebDriver driver){
        return new UserHomePageObject(driver);
    }

    public static UserPostPageObject openUserPostPage(WebDriver driver){
        return new UserPostPageObject(driver);
    }

    public static NavigationMenuPageObject openNavigationMenu(WebDriver driver){
        return new NavigationMenuPageObject(driver);
    }
}
