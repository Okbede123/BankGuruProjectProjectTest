package actions.pageobject;

import cores.commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {

    WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
