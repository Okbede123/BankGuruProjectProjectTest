package actions.pageobject.wordpress;

import cores.commons.BasePage;
import interfaceUI.wordpress.UserPostPageUI;
import org.openqa.selenium.WebDriver;

public class UserPostPageObject extends BasePage {
    WebDriver driver;
    public UserPostPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isDisplayTitle(String title){
        return isElementDisplayed(UserPostPageUI.DISPLAY_TITLE,title);
    }

    public boolean isDisplayBody(String body){
        return isElementDisplayed(UserPostPageUI.DISPLAY_BODY,body);
    }

    public boolean isDisplayTag(String tag){
        return isElementDisplayed(UserPostPageUI.DISPLAY_TAG,tag);
    }
}
