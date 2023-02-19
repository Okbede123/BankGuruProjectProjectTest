package cores.commons.factory_environment;

import actions.pageobject.factorybrowser.ChromeDriverManager;
import actions.pageobject.factorybrowser.EdgeDriverManager;
import actions.pageobject.factorybrowser.FirefoxDriverManager;
import cores.commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalFactory {

    private WebDriver driver;

    private String browserName;


    public LocalFactory(String browserName){
    this.browserName = browserName;
    }

    public WebDriver createDriver(){
        System.setProperty("webdriver.chrome.driver", GlobalConstant.LINK_PROJECT+"chromedriver.exe");
        switch (browserName){
            case "chrome":{
                driver = new ChromeDriverManager().getBrowser();
                break;
            }
            case "firefox":{
                driver = new FirefoxDriverManager().getBrowser();
                break;
            }
            case "edge":{
                driver = new EdgeDriverManager().getBrowser();
                break;
            }
            default:{
                System.out.println("not found driver");
                break;
            }
        }
        return driver;
    }
}
