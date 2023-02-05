package actions.pageobject;

import cores.commons.BasePage;
import interfaceUI.MenuSubNavigationUI;
import org.openqa.selenium.WebDriver;

public class MenuSubNavigation extends BasePage {
    WebDriver driver;

    public MenuSubNavigation(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public NewCustomerPageObject goToCreateNewCustomerFromMenuSubNav(String createCustomer){
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,createCustomer);
        return PageGeneralManager.openNewCustomerPage(driver);
    }
}
