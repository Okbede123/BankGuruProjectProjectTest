package cores.commons;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class BaseTest {
    WebDriver driver;
    public WebDriver getDriver(){
        return this.driver;
    }

    public WebDriver openBrowser(String browser,String nameUrl){
        System.setProperty("webdriver.chrome.driver",GlobalConstant.LINK_PROJECT+"chromedriver.exe");
        switch (browser){
            case "chrome":{
                driver = new ChromeDriver();
                break;
            }
            case "firefox":{
                driver = new FirefoxDriver();
                break;
            }
            case "edge":{
                driver = new EdgeDriver();
                break;
            }
            default:{
                System.out.println("not found driver");
                break;
            }
        }
        driver.manage().window().maximize();
        driver.get(nameUrl);
        return driver;
    }


    public WebDriver openBrowserGrid(String browser,String nameUrl,String osName,String ipAddress,String port){
        DesiredCapabilities capability = null;
        Platform platform = null;

        if (osName.contains("windows")) {
            platform = Platform.WINDOWS;
        } else {
            platform = Platform.MAC;
        }

        switch (browser) {
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
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", ipAddress, port)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.get(nameUrl);
        return driver;
    }


    public WebDriver openBrowserGrid_BrowserStack(String browser,String nameUrl,String osName,String osVersion){
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("os",osName);
        capability.setCapability("osVersion",osVersion);
        capability.setCapability("browser",browser);
        capability.setCapability("browserVersion","latest");
        capability.setCapability("browserstack.debug","true");
        capability.setCapability("project","Bankguru");
        capability.setCapability("resolution","1920x1080");
        capability.setCapability("name","Run on "+ osName+" | "+ osVersion + "  | " + browser);

//        if(osName.contains("Windows")){
//            capability.setCapability("resolution","1920x1080");
//        }
//        else {
//            capability.setCapability("resolution","1920x1440");
//        }
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstant.BROWSER_STACK_URL),capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.get(nameUrl);
        return driver;
    }






    public WebDriver openBrowserWithEnvironment(String browser,String url){
        System.setProperty("webdriver.chrome.driver",GlobalConstant.LINK_PROJECT +"chromedriver.exe");
        switch (browser){
            case "chrome":{
                driver = new ChromeDriver();
                break;
            }
            case "firefox":{
                driver = new FirefoxDriver();
                break;
            }
            case "edge":{
                driver = new EdgeDriver();
                break;
            }
            default:{
                System.out.println("not found driver");
                break;
            }
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public String getEnvironment(String env){
        String envUrl = null;
        Environment_List environment_list =Environment_List.valueOf(env.toUpperCase());
        if(environment_list == Environment_List.DEV){
            envUrl = "https://demo.nopcommerce.com/";
        } else if (environment_list == Environment_List.TESTING) {
            envUrl = "https://admin-demo.nopcommerce.com/";
        } else if (environment_list == Environment_List.LIVE) {
            envUrl = "http://staging-orangehrmlive.com/";
        }
        return envUrl;
    }

    public int getRandomNum(){
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    public void sleepInTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
