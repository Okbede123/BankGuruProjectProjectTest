package testcase;

import actions.pageobject.*;
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

public class CreateCustomerAndCheck extends BaseTest {

    WebDriver driver;

    LoginPageObject loginPageObject;
    ManagerHomePage managerHomePage;
    NewCustomerPageObject newCustomerPageObject;
    EditCustomerPageObject editCustomerPageObject;
    NewAccountPageObject newAccountPageObject;
    String inputFieldCustomerName = "AUTOMATION TESTING";
    String inputFieldDateOfBirth = "01/01/1989";
    String inputAddressField = "PO Box 911 8331 Duis Avenue";
    String inputFieldCity = "Tampa";
    String inputFieldState = "FL";
    String inputFieldPin = "466250";
    String inputFieldMobileNumber = "4555442476";
    String inputFieldEmail = getRandomNum() + "automation@gmail.com";
    String inputFieldPassword = "1";
    String customerID;

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
       managerHomePage = loginPageObject.inputUserNamePassAndLogin(GlobalConstant.USER_NAME,GlobalConstant.PASSWORD,"LOGIN");
        ExtentManager.getTest().log(Status.INFO,"click to create customer");
       newCustomerPageObject = managerHomePage.openMenuSubNavigation().goToCreateCustomerMenuSubNav("New Customer");
        ExtentManager.getTest().log(Status.INFO,"input field customer name");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldCustomerName,"Customer Name");
        ExtentManager.getTest().log(Status.INFO,"input field day of birth");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldDateOfBirth,"Date of Birth");
        ExtentManager.getTest().log(Status.INFO,"input field address");
       newCustomerPageObject.inputInformationAddressCustomer(inputAddressField);
        ExtentManager.getTest().log(Status.INFO,"input field city field");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldCity,"City");
        ExtentManager.getTest().log(Status.INFO,"input field state field");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldState,"State");
        ExtentManager.getTest().log(Status.INFO,"input field pin field");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldPin,"PIN");
        ExtentManager.getTest().log(Status.INFO,"input field mobile field");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldMobileNumber,"Mobile Number");
        ExtentManager.getTest().log(Status.INFO,"input field email field");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldEmail,"E-mail");
        ExtentManager.getTest().log(Status.INFO,"input field password field");
       newCustomerPageObject.inputInformationAddressCustomer(inputFieldPassword,"Password");
       newCustomerPageObject.clickToButtonCreateCustomer("submit");
        ExtentManager.getTest().log(Status.INFO,"verify title customer");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyCustomerTitle(),"Customer Registered Successfully!!!");
        ExtentManager.getTest().log(Status.INFO,"verify text name customer");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Customer Name"),"AUTOMATION TESTING");
        ExtentManager.getTest().log(Status.INFO,"verify text sex");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Gender"),"male");
        ExtentManager.getTest().log(Status.INFO,"verify text date of birth");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Birthdate"),"1989-01-01");
        ExtentManager.getTest().log(Status.INFO,"verify text address");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Address"),"PO Box 911 8331 Duis Avenue");
        ExtentManager.getTest().log(Status.INFO,"verify text city");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("City"),"Tampa");
        ExtentManager.getTest().log(Status.INFO,"verify text state");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("State"),"FL");
        ExtentManager.getTest().log(Status.INFO,"verify text pin");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Pin"),"466250");
        ExtentManager.getTest().log(Status.INFO,"verify text mobile");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Mobile No."),"4555442476");
        ExtentManager.getTest().log(Status.INFO,"verify text email");
        Assert.assertEquals(newCustomerPageObject.getTextVerifyField("Email"),inputFieldEmail);
        customerID = newCustomerPageObject.getTextVerifyField("Customer ID");
    }

    //@Test
    public void TC_02_Edit_CustomerAndCheck(){
        editCustomerPageObject = newCustomerPageObject.openMenuSubNavigation().goToEditCustomerMenuSubNav("Edit Customer");
        editCustomerPageObject.inputCustomerIdandSubmit(customerID);
        editCustomerPageObject.inputInformationAddressCustomerPageEdit("1883 Cursus Avenue");
        editCustomerPageObject.inputInformationEditCustomer("Houston","City");
        editCustomerPageObject.inputInformationEditCustomer("0912911231","Mobile Number");
        editCustomerPageObject.inputInformationEditCustomer("Texas","State");
        //pending
    }

    //@Test
    public void TC_03_AddNewAccountAndCheck(){
            newAccountPageObject = newCustomerPageObject.openMenuSubNavigation().goToNewAccountMenuSubNav("New Account");
            newAccountPageObject.inputAddNewAccountForm(customerID,"Current","60000");
            Assert.assertEquals(newAccountPageObject.getTextTitleEditSuccessfully(),"Account Generated Successfully!!!");
            Assert.assertEquals(newAccountPageObject.getTextCurrentAmount(),"60000");
    }

}
