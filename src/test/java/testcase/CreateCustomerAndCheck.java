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
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class CreateCustomerAndCheck extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    LoginPageObject loginPageObject;
    ManagerHomePage managerHomePage;
    NewCustomerPageObject newCustomerPageObject;
    String userName = "mngr476454";
    String password = "YjepAtE";
    String inputFieldCustomerName = "AUTOMATION TESTING";
    String inputFieldDateOfBirth = "01/01/1989";
    String inputAddressField = "PO Box 911 8331 Duis Avenue";
    String inputFieldCity = "Tampa";
    String inputFieldState = "FL";
    String inputFieldPin = "466250";
    String inputFieldMobileNumber = "4555442476";
    String inputFieldEmail = "automation@gmail.com" + getRandomNum();
    String inputFieldPassword = "1";

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browser){
        driver = openBrowser(browser,"https://demo.guru99.com/v4/");
        loginPageObject = PageGeneralManager.openLoginPage(driver);
    }

    @Test
    public void TC_01_CreateCustomerAndCheckSuccessfully(Method method){
        ExtentManager.startTest(method.getName(),"TC_01_CreateCustomerAndCheckSuccessfully");
        ExtentManager.getTest().log(Status.INFO,"input username,password and login");
       managerHomePage = loginPageObject.inputUserNamePassAndLogin(userName,password,"LOGIN");
        ExtentManager.getTest().log(Status.INFO,"click to create customer");
       newCustomerPageObject = managerHomePage.goToCreateNewCustomerFromMenuSubNav("New Customer");
        ExtentManager.getTest().log(Status.INFO,"input field customer name");
       newCustomerPageObject.inputInformationCustomer(inputFieldCustomerName,"Customer Name");
        ExtentManager.getTest().log(Status.INFO,"input field day of birth");
       newCustomerPageObject.inputInformationCustomer(inputFieldDateOfBirth,"Date of Birth");
        ExtentManager.getTest().log(Status.INFO,"input field address");
       newCustomerPageObject.inputInformationCustomer(inputAddressField);
        ExtentManager.getTest().log(Status.INFO,"input field city field");
       newCustomerPageObject.inputInformationCustomer(inputFieldCity,"City");
        ExtentManager.getTest().log(Status.INFO,"input field state field");
       newCustomerPageObject.inputInformationCustomer(inputFieldState,"State");
        ExtentManager.getTest().log(Status.INFO,"input field pin field");
       newCustomerPageObject.inputInformationCustomer(inputFieldPin,"PIN");
        ExtentManager.getTest().log(Status.INFO,"input field mobile field");
       newCustomerPageObject.inputInformationCustomer(inputFieldMobileNumber,"Mobile Number");
        ExtentManager.getTest().log(Status.INFO,"input field email field");
       newCustomerPageObject.inputInformationCustomer(inputFieldEmail,"E-mail");
        ExtentManager.getTest().log(Status.INFO,"input field password field");
       newCustomerPageObject.inputInformationCustomer(inputFieldPassword,"Password");
       newCustomerPageObject.clickToButtonCreateCustomer("submit");
        ExtentManager.getTest().log(Status.INFO,"verify title customer");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyCustomerTitle(),"Customer Registered Successfully!!!");
        ExtentManager.getTest().log(Status.INFO,"verify text name customer");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Customer Name",inputFieldCustomerName),"AUTOMATION TESTING");
        ExtentManager.getTest().log(Status.INFO,"verify text sex");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Gender","male"),"male");
        ExtentManager.getTest().log(Status.INFO,"verify text date of birth");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Birthdate","1989-01-01"),"1989-01-01");
        ExtentManager.getTest().log(Status.INFO,"verify text address");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Address",inputAddressField),"PO Box 911 8331 Duis Avenue");
        ExtentManager.getTest().log(Status.INFO,"verify text city");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("City",inputFieldCity),"Tampa");
        ExtentManager.getTest().log(Status.INFO,"verify text state");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("State",inputFieldState),"FL");
        ExtentManager.getTest().log(Status.INFO,"verify text pin");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Pin",inputFieldPin),"466250");
        ExtentManager.getTest().log(Status.INFO,"verify text mobile");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Mobile No.",inputFieldMobileNumber),"4555442476");
        ExtentManager.getTest().log(Status.INFO,"verify text email");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Email",inputFieldEmail),inputFieldEmail);
    }
}
