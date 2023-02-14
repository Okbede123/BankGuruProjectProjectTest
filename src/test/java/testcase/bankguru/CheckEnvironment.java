package testcase.bankguru;

import actions.pageobject.bankguru.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.GlobalConstant;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CheckEnvironment extends BaseTest {

    WebDriver driver;



    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browser,String url){
        driver = openBrowserWithEnvironment(browser,url);
    }
    @Test
    public void TC_01_CreateCustomerAndCheckSuccessfully(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_CreateCustomerAndCheckSuccessfully");
        ExtentManager.getTest().log(Status.INFO,"input username,password and login");
    }

    @Test
    public void TC_02_Edit_CustomerAndCheck(Method method){
        ExtentManager.startTest(method.getName(),"TC_02_Edit_CustomerAndCheck");
        ExtentManager.getTest().log(Status.INFO,"check tc2");
    }


}
