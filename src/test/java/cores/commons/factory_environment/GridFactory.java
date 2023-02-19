package cores.commons.factory_environment;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridFactory {
    WebDriver driver;

    private String browserName;
    private String ipAddress;
    private String portNumber;

    private String osName;

    public GridFactory(String browserName,String ipAddress,String portNumber,String osName){
        this.browserName = browserName;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        this.osName = osName;
    }

    public WebDriver createDriver(){
        DesiredCapabilities capability = null;
        Platform platform = Platform.ANY;

//        if (osName.contains("Windows")) {
//            platform = Platform.ANY;
//        } else {
//            platform = Platform.ANY;
//        }

        switch (browserName) {
            case "firefox" :
                capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(platform);

                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.merge(capability);
                break;
            case "chrome" :
                capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(platform);

                ChromeOptions cOptions = new ChromeOptions();
                cOptions.merge(capability);
                break;
            case "edge" :
                capability = DesiredCapabilities.edge();
                capability.setBrowserName("edge");
                capability.setPlatform(platform);

                EdgeOptions eOptions = new EdgeOptions();
                eOptions.merge(capability);
                break;
            default :
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
