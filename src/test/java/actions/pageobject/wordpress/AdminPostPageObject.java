package actions.pageobject.wordpress;

import cores.commons.BasePage;
import interfaceUI.wordpress.AdminPostPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AdminPostPageObject extends NavigationMenuPageObject {
    WebDriver driver;
    public AdminPostPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickToPublishPost(String button){
        clickToElements(AdminPostPageUI.BUTTON_POST,button);
        clickToElements(AdminPostPageUI.CONFIRM_PUBLISH);
    }

    public void clickToEditPost(String button){
        clickToElements(AdminPostPageUI.BUTTON_POST,button);
    }

    public void goToSearchPost(String value){
        backPage();
        refeshPage();
        sendKeysToElement(AdminPostPageUI.SEARCH_POST,value);
        clickToElements(AdminPostPageUI.BUTTON_SEARCH_POST);
    }

    public void goToSearchPostFromEdit(String value){
        sendKeysToElement(AdminPostPageUI.SEARCH_POST,value);
        clickToElements(AdminPostPageUI.BUTTON_SEARCH_POST);
    }

    public void clickToConfigPost(String title,String config){
        moveToElement(AdminPostPageUI.SHOW_CONFIG_POST,title);
        clickToElements(AdminPostPageUI.CONFIG_POST,title,config);
    }

    public String getTextInPostAdmin(String value){
        waitElementVisibility(AdminPostPageUI.VERIFY_NAME_POST_DISPLAY,value);
        return getText(AdminPostPageUI.VERIFY_NAME_POST_DISPLAY,value);
    }

    public boolean verifyPostMovedToTrash(){
        return isElementDisplayed(AdminPostPageUI.VERIFY_TEXT_TRASH);
    }

    public String verifyPostNotFound(){
        return getText(AdminPostPageUI.VERIFY_NOT_FOUND_POST);
    }

    public boolean verifyPublishSuccessful(){
        waitElementVisibility(AdminPostPageUI.VERIFY_POST,"Post published.");
        return isElementDisplayed(AdminPostPageUI.VERIFY_POST,"Post published.");
    }

    public boolean verifyUpdateSuccessful(){
        waitElementVisibility(AdminPostPageUI.VERIFY_POST,"Post updated.");
        return isElementDisplayed(AdminPostPageUI.VERIFY_POST,"Post updated.");
    }

    public void addNewPost(String title,String body){
        clickToElements(AdminPostPageUI.ADD_NEW_POST);
        sendKeysToElement(AdminPostPageUI.INPUT_TITLE,title);
        clickToElements(AdminPostPageUI.CLICK_TO_DES);
        sendKeysToElement(AdminPostPageUI.INPUT_DES,body);
        clickToElements(AdminPostPageUI.CLICK_OUT_DES);
//        moveToElement(AdminPostPageUI.CHOOSE_CATEGORIES,"Categories");
//        clickByJs(AdminPostPageUI.CHOOSE_CATEGORIES,"Categories");
        clickToElements(AdminPostPageUI.RADIO_CHECKBOX_CATEGORIES,"test1");
    }

    public void editPost(String title,String body){
        sendKeysToElement(AdminPostPageUI.INPUT_TITLE,title);
        clickToElements(AdminPostPageUI.INPUT_DES);
        sendKeysToElement(AdminPostPageUI.INPUT_DES,body);
        clickToElements(AdminPostPageUI.CLICK_OUT_DES);
    }

    public void inPutTag(String tag){
        sendKeysToElement(AdminPostPageUI.ADD_NEW_TAG,tag);
        sendKeysToElement(AdminPostPageUI.ADD_NEW_TAG,Keys.ENTER);
    }


}
