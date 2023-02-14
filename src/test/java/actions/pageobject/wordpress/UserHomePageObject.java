package actions.pageobject.wordpress;

import cores.commons.BasePage;
import interfaceUI.wordpress.UserHomePageUI;
import interfaceUI.wordpress.UserPostPageUI;
import org.openqa.selenium.WebDriver;

public class UserHomePageObject extends BasePage {
    WebDriver driver;
    public UserHomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public UserPostPageObject clickToPost(String post){
        clickToElements(UserHomePageUI.CLICK_TO_POST,post);
      return PageGeneralManager.openUserPostPage(driver);
    }

    public boolean elementNotDisplay(String post){
        return ElementNotDisplay(UserHomePageUI.VERIFY_TO_POST,post);
    }

    public boolean isDisplayPost(String post){
        return isElementDisplayed(UserHomePageUI.VERIFY_TO_POST,post);
    }
}
