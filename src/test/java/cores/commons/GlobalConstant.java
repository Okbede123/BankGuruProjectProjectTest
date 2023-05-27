package cores.commons;



public class GlobalConstant {

    public static final String OS_NAME = System.getProperty("os.name");

    public static final String GETLINK_PROJECT = System.getProperty("user.dir");
    public static final String LINK_PROJECT = GETLINK_PROJECT + "\\src\\test\\java\\filefolder\\";
    public static final String UPLOAD_PICTURES = "xpath=//input[@type = 'file']";
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String USER_NAME = "mngr486117";
    public static final String PASSWORD = "gEgArez";

    public static final String BROWSER_NAME = "cv_zdscw7";
    public static final String BROWSER_AUTOMATE_KEY = "PJf6JMnc9RVPW4wNw6Kg";
    public static final String BROWSER_STACK_URL = "https://"+ BROWSER_NAME+ ":"+ BROWSER_AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub";
}
