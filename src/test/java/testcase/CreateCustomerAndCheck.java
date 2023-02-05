package testcase;

import actions.pageobject.LoginPageObject;
import actions.pageobject.ManagerHomePage;
import actions.pageobject.NewCustomerPageObject;
import actions.pageobject.PageGeneralManager;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CreateCustomerAndCheck extends BaseTest {
    WebDriver driver;

    LoginPageObject loginPageObject;
    ManagerHomePage managerHomePage;
    NewCustomerPageObject newCustomerPageObject;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browser){
        driver = openBrowser(browser,"https://demo.guru99.com/v4/");
        loginPageObject = PageGeneralManager.openLoginPage(driver);
    }

    @Test
    public void TC_01_CreateCustomerAndCheckSuccessfully(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_CreateCustomerAndCheckSuccessfully");
        ExtentManager.getTest().log(Status.INFO,"create customer");
       managerHomePage = loginPageObject.inputUserNamePassAndLogin("mngr476454","YjepAtE","LOGIN");
       newCustomerPageObject = managerHomePage.goToCreateNewCustomerFromMenuSubNav("New Customer");
       newCustomerPageObject.inputInformationCustomer("AUTOMATION TESTING","Customer Name");
       newCustomerPageObject.inputInformationCustomer("01/01/1989","Date of Birth");
       newCustomerPageObject.inputInformationCustomer("PO Box 911 8331 Duis Avenue");
       newCustomerPageObject.inputInformationCustomer("Tampa","City");
       newCustomerPageObject.inputInformationCustomer("FL","State");
       newCustomerPageObject.inputInformationCustomer("466250","PIN");
       newCustomerPageObject.inputInformationCustomer("4555442476","Mobile Number");
       newCustomerPageObject.inputInformationCustomer("automation@gmail.com" +getRandomNum(),"E-mail");
       newCustomerPageObject.inputInformationCustomer("1","Password");
       newCustomerPageObject.clickToButtonCreateCustomer("submit");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyCustomerTitle(),"Customer Registered Successfully!!!");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Customer Name","AUTOMATION TESTING"),"AUTOMATION TESTING");
    }
}
