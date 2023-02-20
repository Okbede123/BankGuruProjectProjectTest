package cores.commons.factory_environment;

import cores.commons.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackFactory {

    WebDriver driver;

    private String browserName;
    private String osName;
    private String osVersion;

    public BrowserStackFactory(String browserName, String osName, String osVersion){
        this.browserName = browserName;
        this.osName = osName;
        this.osVersion = osVersion;
    }

    public WebDriver createBrowser(){
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os",osName);
        capability.setCapability("osVersion",osVersion);
        capability.setCapability("browser",browserName);
        capability.setCapability("browserVersion","latest");
        capability.setCapability("browserstack.debug","true");
        capability.setCapability("project","Bankguru");
        capability.setCapability("resolution","1920x1080");
        capability.setCapability("name","Run on "+ osName+" | "+ osVersion + "  | " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstant.BROWSER_STACK_URL),capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
