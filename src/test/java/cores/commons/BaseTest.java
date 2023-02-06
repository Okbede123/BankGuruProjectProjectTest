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

    public int getRandomNum(){
        Random rand = new Random();
        return rand.nextInt(10000);
    }
}
