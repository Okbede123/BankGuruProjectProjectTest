package interfaceUI.wordpress;

public class AdminPostPageUI {

    public static final String ADD_NEW_POST = "xpath=//h1[contains(text(),'Posts')]//following-sibling::a";
    public static final String INPUT_TITLE = "xpath=//h1[@aria-label = 'Add title']";
    public static final String CLICK_TO_DES = "xpath=//p[text() ='Type / to choose a block']";

    public static final String INPUT_DES = "xpath=//p[@role ='document']";

    public static final String CLICK_OUT_DES = "xpath=//div[@class ='editor-styles-wrapper block-editor-writing-flow']";
    public static final String CHOOSE_CATEGORIES = "xpath=//h2//button[text() ='%s']";
    public static final String RADIO_CHECKBOX_CATEGORIES = "xpath=//label[text() ='%s']//preceding-sibling::span/input";
    public static final String BUTTON_POST = "xpath=//a//following-sibling::button[text() = '%s']";

    public static final String ADD_NEW_TAG = "xpath=//label[text() ='Add New Tag']//parent::div//div/input";
    public static final String CONFIRM_PUBLISH = "xpath=//div[@class ='editor-post-publish-panel__header-publish-button']/button";

    public static final String VERIFY_POST = "xpath=//div[@class ='components-snackbar__content' and text() = '%s']";

    public static final String SEARCH_POST = "xpath=//input[@type ='search']";
    public static final String VERIFY_NAME_POST_DISPLAY ="xpath=//strong/a[text() ='%s']";

    public static final String SHOW_CONFIG_POST = "xpath=//strong/a[text() ='%s']//parent::strong//parent::td";

    public static final String CONFIG_POST = "xpath=//a[text() ='%s']//parent::strong//following-sibling::div/span/a[text() ='%s']";

    public static final String BUTTON_SEARCH_POST = "xpath=//input[@value ='Search Posts']";

    public static final String VERIFY_TEXT_TRASH = "xpath=//p[text() ='1 post moved to the Trash. ']";

    public static final String VERIFY_NOT_FOUND_POST = "xpath=//td[text() ='No posts found.']";
}
