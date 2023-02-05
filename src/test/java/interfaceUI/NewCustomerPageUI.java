package interfaceUI;

public class NewCustomerPageUI {

    public static final String INPUT_INFORMATION_CUSTOMER = "xpath=//td[text() = '%s']//parent::tr//td/input";
    public static final String INPUT_ADDRESS = "xpath=//td[text() = 'Address']//parent::tr//td/textarea";
    public static final String BUTTONS = "xpath=//input[@type = '%s']";
    public static final String VERIFY_CREATE_CUSTOMER_SUCCESSFULLY = "xpath=//p[text() ='Customer Registered Successfully!!!']";
    public static final String VERIFY_FIELD = "xpath=//td[text() ='%s']//following-sibling::td[text() ='%s']";
}
