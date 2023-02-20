package actions.pageobject.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowser() {
        //thêm các option tại đây
        return new EdgeDriver();
    }
}
