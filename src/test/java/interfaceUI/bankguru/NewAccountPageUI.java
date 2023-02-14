package interfaceUI.bankguru;

public class NewAccountPageUI  {

    public static final String SELECT_ACCOUNT_TYPE = "xpath=//select[@name ='selaccount']";
    public static final String CHOOSE_FROM_SELECT = "xpath=//option[text() ='Current']";
    public static final String INITIAL_DEPOSIT = "xpath=//td[contains(text(),'Initial deposit')]//parent::tr//td/input";
    public static final String TITLE_ADD_NEW_ACCOUNT_SUCCESSFULLY = "xpath=//p[text()='Account Generated Successfully!!!']";
    public static final String GETTEXT_CREATE_SUCCSESSFULLY = "xpath=//td[text() = '%s']//following-sibling::td";
}
