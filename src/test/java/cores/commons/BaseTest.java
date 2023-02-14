package cores.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Random;

public class BaseTest {
    WebDriver driver;
    public WebDriver getDriver(){
        return this.driver;
    }

    public WebDriver openBrowser(String browser,String nameUrl){
        //System.setProperty("webdriver.chrome.driver",GlobalConstant.LINK_PROJECT+"chromedriver.exe");
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

    public WebDriver openBrowserWithEnvironment(String browser,String url){
        //System.setProperty("webdriver.chrome.driver",GlobalConstant.LINK_PROJECT+"chromedriver.exe");
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
