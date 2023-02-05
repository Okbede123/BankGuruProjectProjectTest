package actions.pageobject;

import cores.commons.BasePage;
import interfaceUI.ManagerHomePageUI;
import org.openqa.selenium.WebDriver;

public class ManagerHomePage extends MenuSubNavigation {

    WebDriver driver;

    public ManagerHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public NewCustomerPageObject clickToNewCustomer(String menuSubLocator){
        clickToElements(ManagerHomePageUI.MENUSUBNAV,menuSubLocator);
        return PageGeneralManager.openNewCustomerPage(driver);
    }
}
