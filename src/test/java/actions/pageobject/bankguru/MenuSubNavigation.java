package actions.pageobject.bankguru;

import cores.commons.BasePage;
import interfaceUI.bankguru.MenuSubNavigationUI;
import org.openqa.selenium.WebDriver;

public class MenuSubNavigation extends BasePage {
    WebDriver driver;
    String getUrl;

    public MenuSubNavigation(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MenuSubNavigation openMenuSubNavigation(){
        return new MenuSubNavigation(driver);
    }

    public NewCustomerPageObject goToCreateCustomerMenuSubNav(String createCustomer){
        getUrl = getNameUrl();
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,createCustomer);
        handlePopupAds("https://demo.guru99.com/v4/manager/addcustomerpage.php");
        return PageGeneralManager.openNewCustomerPage(driver);
    }

    public EditCustomerPageObject goToEditCustomerMenuSubNav(String editCustomer){
        getUrl = getNameUrl();
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,editCustomer);
        handlePopupAds("https://demo.guru99.com/v4/manager/EditCustomer.php");
        return PageGeneralManager.openEditCustomerPage(driver);
    }

    public NewAccountPageObject goToNewAccountMenuSubNav(String newAccount){
        getUrl = getNameUrl();
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,newAccount);
        handlePopupAds(getUrl);
        return PageGeneralManager.openNewAccountPage(driver);
    }

    public EditAccountPageObject goToEditAccountMenuSubNav(String editAccount){
        getUrl = getNameUrl();
        clickToElements(MenuSubNavigationUI.MENUSUBNAVIGATION,editAccount);
        handlePopupAds(getUrl);
        return PageGeneralManager.openEditAccountPage(driver);
    }

    public void handlePopupAds(String url){
        if(getNameUrl().contains("google_vignette")){
            goToURl(url);
        }
    }
}
