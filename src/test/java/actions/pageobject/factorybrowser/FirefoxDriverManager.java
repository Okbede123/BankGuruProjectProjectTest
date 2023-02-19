package actions.pageobject.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowser() {
        //thêm các option tại đây
        return new FirefoxDriver();
    }
}
