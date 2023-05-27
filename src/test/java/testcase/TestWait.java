package testcase;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWait {
    private static final TestWait instance = new TestWait();

    //private constructor to avoid client applications to use constructor
    private TestWait(){

    }

    public static TestWait getInstance(){
        return instance;
    }

    public void getResult(){
        System.out.println("result");
    }
}
