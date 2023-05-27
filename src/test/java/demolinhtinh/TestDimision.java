package demolinhtinh;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDimision {

    //X càng to càng sang phải
    //Y càng to càng xuống dưới,
    WebDriver driver;
    WebDriverWait webDriverWait;

    Actions actions;
    Dimension dimension;

    Dimension dimension1 = new Dimension(1936,1100);

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver,5);
        actions = new Actions(driver);
        driver.get("https://jqueryui.com/slider/");
        driver.manage().window().maximize();
//        dimension = driver.manage().window().getSize();
    }

    //@Test
    public void TC_01(){
//        System.out.println(dimension);
        sleepInTime(2);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class ='demo-frame']")));
        WebElement scroll = driver.findElement(By.xpath("//div[@id ='slider']/span"));
//        System.out.println(scroll.getSize().getWidth());
//        System.out.println(scroll.getSize().getHeight());
        System.out.println(scroll.getLocation());
        actions.moveToElement(scroll).clickAndHold(scroll).moveByOffset(120,0).release().perform();
        System.out.println(scroll.getLocation());
        sleepInTime(2);
        actions.moveToElement(scroll).clickAndHold(scroll).moveByOffset(-120,0).release().perform();
        System.out.println(scroll.getLocation());
    }

    @Test
    public void TC_02(){
        driver.findElement(By.xpath("//a[text()='Draggable']")).click();
        sleepInTime(2);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class ='demo-frame']")));
        WebElement drag = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        //lấy ra location của element
        System.out.println(drag.getLocation());
        actions.moveToElement(drag).clickAndHold(drag).moveByOffset(0,28).release().perform();
        sleepInTime(2);
        System.out.println(drag.getLocation());
        //move by offset, click và giữ vào 1 element xong move theo vị trí

        actions.moveToElement(drag).clickAndHold(drag).moveByOffset(0,28).release().perform();
        sleepInTime(2);
        actions.moveToElement(drag).clickAndHold(drag).moveByOffset(0,28).release().perform();
        sleepInTime(2);
        actions.moveToElement(drag).clickAndHold(drag).moveByOffset(0,-18).release().perform();
        sleepInTime(2);
        actions.moveToElement(drag).clickAndHold(drag).moveByOffset(60,0).release().perform();
    }

    @Test
    public void TC_03(){
        driver.findElement(By.xpath("//a[text()='Droppable']")).click();
        sleepInTime(2);
        WebElement iframe = driver.findElement( By.xpath("//iframe[@class ='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement drag = driver.findElement(By.xpath("//div[@id = 'draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id = 'droppable']"));
        System.out.println(drag.getLocation() + " drag");
        System.out.println(drop.getLocation() + " drop");
        //cái dragAndDropBy này là chọn element xong di đến vị trí luôn, ko cần thêm step click and hold xong move by offset nữa
        actions.moveToElement(drag).dragAndDropBy(drag,20,20).perform();
        //click vào 1 element xong kéo nó đi luôn
        actions.clickAndHold(drag).moveToElement(drag,90,30).perform();
    }

    public void sleepInTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
