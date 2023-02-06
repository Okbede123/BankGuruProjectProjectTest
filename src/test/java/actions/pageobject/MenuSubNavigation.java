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

    public MenuSubNavigation openMenuSubNavigation(){
        return new MenuSubNavigation(driver);
    }

    public NewCustomerPageObject goToCreateCustomerMenuSubNav(String createCustomer){
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,createCustomer);
        handlePopupAds("https://demo.guru99.com/v4/manager/addcustomerpage.php");
        return PageGeneralManager.openNewCustomerPage(driver);
    }

    public EditCustomerPageObject goToEditCustomerMenuSubNav(String editCustomer){
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,editCustomer);
        handlePopupAds("https://demo.guru99.com/v4/manager/EditCustomer.php");
        return PageGeneralManager.openEditCustomerPage(driver);
    }

    public NewAccountPageObject goToNewAccountMenuSubNav(String newAccount){
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,newAccount);
        handlePopupAds("https://demo.guru99.com/v4/manager/addAccount.php");
        return PageGeneralManager.openNewAccountPage(driver);
    }

    public void handlePopupAds(String url){
        if(getNameUrl().contains("google_vignette")){
            goToURl(url);
        }
    }
}
