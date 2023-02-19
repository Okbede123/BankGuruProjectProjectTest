package actions.pageobject.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowser() {
        //thêm các option tại đây
        return new ChromeDriver();
    }
}
