package testcase.wordpress.admin;

import actions.pageobject.wordpress.*;
import com.aventstack.extentreports.Status;
import cores.commons.BaseTest;
import cores.commons.reportconfig.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Admin_01_Post extends BaseTest {
    WebDriver driver;
    String userUrl,adminUrl,browser;
     String inputTitle = "test title";
     String inputBody = "test body";
     String inputTag = "testtag";
     String editTag = "edittag";

     String editTitle = "edit title";
     String editBody = "edit body";

    AdminPostPageObject adminPostPageObject;
    AdminLoginPageObject adminLoginPageObject;
    AdminDashboardPageObject adminDashboardPageObject;
    UserPostPageObject userPostPageObject;
    UserHomePageObject userHomePageObject;



    @Parameters({"browser","userUrl","adminUrl"})
    @BeforeClass
    public void beforeClass(String browser,String userUrl,String adminUrl){
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;
        this.browser = browser;
        driver = openBrowser(browser,adminUrl);
        adminLoginPageObject = PageGeneralManager.openAdminLogin(driver);
        adminDashboardPageObject = adminLoginPageObject.sendUserNamePassAndLogin("automationduc","halong123");
    }

    @Test
    public void Post_01_Create_New_Post(Method method){
        ExtentManager.startTest(method.getName(),"Post_01_Create_New_Post" + browser);
        ExtentManager.getTest().log(Status.INFO,"Post_01 -Step 1 :Click to Post");
       adminPostPageObject = adminDashboardPageObject.clickToPostMyDashBoard("Posts");
       adminPostPageObject.addNewPost(inputTitle,inputBody);
       adminPostPageObject.inPutTag(inputTag);
       sleepInTime(1);
       adminPostPageObject.clickToPublishPost("Publish");
       sleepInTime(2);
        Assert.assertTrue(adminPostPageObject.verifyPublishSuccessful());
    }

    @Test
    public void Post_02_Search_View_Post(Method method){
        ExtentManager.startTest(method.getName(),"Post_02_Search_View_Post" + browser);
        ExtentManager.getTest().log(Status.INFO,"search view post");
        adminPostPageObject.goToSearchPost(inputTitle);
        Assert.assertEquals(adminPostPageObject.getTextInPostAdmin(inputTitle),"test title");
        //driver = openBrowser(browser,userUrl);
        //userHomePageObject = PageGeneralManager.openUserHome(driver);
        userHomePageObject = adminPostPageObject.openUserHomePage(userUrl);
        Assert.assertTrue(userHomePageObject.isDisplayPost(inputTitle));
        userPostPageObject = userHomePageObject.clickToPost(inputTitle);
        Assert.assertTrue(userPostPageObject.isDisplayTitle(inputTitle));
        Assert.assertTrue(userPostPageObject.isDisplayBody(inputBody));
        Assert.assertTrue(userPostPageObject.isDisplayTag(inputTag));
    }

    @Test
    public void Post_03_Edit_Post(Method method){
        ExtentManager.startTest(method.getName(),"Post_03_Edit_Post" + browser);
        ExtentManager.getTest().log(Status.INFO,"edit post");
        //driver = openBrowser(browser,adminUrl);
        //adminLoginPageObject = PageGeneralManager.openAdminLogin(driver);
        adminLoginPageObject = userPostPageObject.openAdminLoginPage(adminUrl);
        //adminDashboardPageObject = adminLoginPageObject.sendUserNamePassAndLogin("automationduc","halong123");
        adminPostPageObject = adminDashboardPageObject.clickToPostMyDashBoard("Posts");
        adminPostPageObject.goToSearchPostFromEdit(inputTitle);
        adminPostPageObject.clickToConfigPost(inputTitle,"Edit");
        adminPostPageObject.editPost(editTitle,editBody);
        adminPostPageObject.inPutTag(editTag);
        sleepInTime(2);
        adminPostPageObject.clickToEditPost("Update");
        Assert.assertTrue(adminPostPageObject.verifyUpdateSuccessful());
        userHomePageObject = adminPostPageObject.openUserHomePage(userUrl);
        Assert.assertTrue(userHomePageObject.isDisplayPost(editTitle));
        userPostPageObject = userHomePageObject.clickToPost(editTitle);
        Assert.assertTrue(userPostPageObject.isDisplayTitle(editTitle));
        Assert.assertTrue(userPostPageObject.isDisplayBody(inputBody+editBody));
        Assert.assertTrue(userPostPageObject.isDisplayTag(editTag));

    }

    @Test
    public void Post_04_Delete_Post(Method method){
        ExtentManager.startTest(method.getName(),"Post_04_Delete_Post" + browser);
        ExtentManager.getTest().log(Status.INFO,"delete post");
        adminLoginPageObject = userPostPageObject.openAdminLoginPage(adminUrl);
        adminPostPageObject = adminLoginPageObject.clickToPostMenuNavigation("Posts");
        adminPostPageObject.goToSearchPostFromEdit(editTitle);
        adminPostPageObject.clickToConfigPost(editTitle,"Trash");
        Assert.assertTrue(adminPostPageObject.verifyPostMovedToTrash());
        adminPostPageObject.goToSearchPostFromEdit(editTitle);
        Assert.assertEquals(adminPostPageObject.verifyPostNotFound(),"No posts found.");
        userHomePageObject = adminPostPageObject.openUserHomePage(userUrl);
        Assert.assertTrue(userHomePageObject.elementNotDisplay(editTitle));
    }
}
