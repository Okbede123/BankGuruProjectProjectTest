package cores.commons;

import actions.pageobject.factorybrowser.ChromeDriverManager;
import actions.pageobject.factorybrowser.EdgeDriverManager;
import actions.pageobject.factorybrowser.FirefoxDriverManager;
import cores.commons.factory_environment.BrowserStackFactory;
import cores.commons.factory_environment.GridFactory;
import cores.commons.factory_environment.LocalFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class BaseTest {

   protected final Log log;
    WebDriver driver;



    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();


     protected BaseTest(){
         log = LogFactory.getLog(getClass());
     }

    public WebDriver getDriver(){
        return this.driver;
    }

    public WebDriver getThreadDriver(){
        return driverThreadLocal.get();
    }

    public WebDriver openBrowserHandleInterFaceDemoThread(String browserName,String url){
        switch (browserName){
            case "chrome":{
                driverThreadLocal.set(new ChromeDriverManager().getBrowser());
                break;
            }

            case "firefox":{
                driverThreadLocal.set(new FirefoxDriverManager().getBrowser());
                break;
            }

            case "edge":{
                driverThreadLocal.set(new EdgeDriverManager().getBrowser());
                break;
            }
        }
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get(url);
        return driverThreadLocal.get();
    }


    public WebDriver openBrowserHandleInterFace(String browserName,String url){
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
         }
            driver.manage().window().maximize();
            driver.get(url);
         return driver;
    }

    public WebDriver getDriver(String browser,String nameUrl,String environmentName,String ipAdress,String port,String osName,String osVersion){
         switch (environmentName){
             case "local":{
                driver = new LocalFactory(browser).createDriver();
                break;
             }
             case "grid":{
                driver = new GridFactory(browser,ipAdress,port,osName).createDriver();
                 break;
             }
             case "browserStack":{
                driver = new BrowserStackFactory(browser,osName,osVersion).createBrowser();
                 break;
             }
             default:{
                 driver = new LocalFactory(browser).createDriver();
                 break;
             }
         }
        driver.manage().window().maximize();
        driver.get(nameUrl);
        return this.driver;
    }


    public WebDriver openBrowser(String browser,String nameUrl){
//        System.setProperty("webdriver.chrome.driver",GlobalConstant.LINK_PROJECT+"chromedriver.exe");
        switch (browser){
            case "chrome":{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "edge":{
                WebDriverManager.edgedriver().setup();
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

    protected void closeBrowserDriver(String env) {
         if(env.equals("local") || env.equals("grid")){
             String cmd = null;
             try {
                 String osName = GlobalConstant.OS_NAME;
                 log.info("OS name = " + osName);

                 String driverInstanceName = driver.toString().toLowerCase();
                 log.info("Driver instance name = " + driverInstanceName);

                 String browserDriverName = null;

                 if (driverInstanceName.contains("chrome")) {
                     browserDriverName = "chromedriver";
                 } else if (driverInstanceName.contains("internetexplorer")) {
                     browserDriverName = "IEDriverServer";
                 } else if (driverInstanceName.contains("firefox")) {
                     browserDriverName = "geckodriver";
                 } else if (driverInstanceName.contains("edge")) {
                     browserDriverName = "msedgedriver";
                 } else if (driverInstanceName.contains("opera")) {
                     browserDriverName = "operadriver";
                 } else {
                     browserDriverName = "safaridriver";
                 }

                 if (osName.contains("Windows")) {
                     cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
                 } else {
                     cmd = "pkill " + browserDriverName;
                 }

                 if (driver != null) {
                     driver.manage().deleteAllCookies();
                     driver.quit();
                 }
             } catch (Exception e) {
                 log.info(e.getMessage());
             } finally {
                 try {
                     Process process = Runtime.getRuntime().exec(cmd);
                     process.waitFor();
                 } catch (IOException e) {
                     e.printStackTrace();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

    protected void closeBrowserDriverThread(String env) {
        if(env.equals("local") || env.equals("grid")){
            String cmd = null;
            try {
                String osName = GlobalConstant.OS_NAME;
                log.info("OS name = " + osName);

                String driverInstanceName = driverThreadLocal.get().toString().toLowerCase();
                log.info("Driver instance name = " + driverInstanceName);

                String browserDriverName = null;

                if (driverInstanceName.contains("chrome")) {
                    browserDriverName = "chromedriver";
                } else if (driverInstanceName.contains("internetexplorer")) {
                    browserDriverName = "IEDriverServer";
                } else if (driverInstanceName.contains("firefox")) {
                    browserDriverName = "geckodriver";
                } else if (driverInstanceName.contains("edge")) {
                    browserDriverName = "msedgedriver";
                } else if (driverInstanceName.contains("opera")) {
                    browserDriverName = "operadriver";
                } else {
                    browserDriverName = "safaridriver";
                }

                if (osName.contains("Windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
                } else {
                    cmd = "pkill " + browserDriverName;
                }

                if (driverThreadLocal != null) {
                    driverThreadLocal.get().manage().deleteAllCookies();
                    driverThreadLocal.get().quit();
                    driverThreadLocal.remove();
                }
            } catch (Exception e) {
                log.info(e.getMessage());
            } finally {
                try {
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
