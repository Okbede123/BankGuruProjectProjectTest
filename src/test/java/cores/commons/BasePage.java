package cores.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BasePage {
    WebDriver driver;

    public String castToParameter(String locator,String ...values){
        return String.format(locator,values);
    }

    public By getByLocator(String locator){
        switch (locator){

            case "id=": case "Id=": case "ID=":{
              return  By.id(locator.substring(3));
            }
            case "class=": case "Class=": case "CLASS=":{
                return By.className(locator.substring(6));
            }
            case "xpath=": case "Xpath=": case "XPATH=":{
                return By.xpath(locator.substring(6));
            }
            case "name=": case "Name=": case "NAME=":{
                return By.name(locator.substring(5));
            }
            default:{
                return null;
            }
        }
    }

    public WebElement searchToElement(String locator, String...values){
      return  driver.findElement(getByLocator(castToParameter(locator,values)));
    }

    public void clickToElement(String locator,String...values){
        searchToElement(locator,values).click();
    }

    public void sendKeysToElement(String locator,String valueToSend,String...values){
        searchToElement(locator,values).sendKeys(valueToSend);
    }

    public void WaitElementVisibility(String locator,String...values){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castToParameter(locator,values))));
    }

    public void WaitElementClick(String locator,String...values){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByLocator(castToParameter(locator,values))));
    }

    public void WaitElementInvisible(String locator,String...values){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castToParameter(locator,values))));
    }

    public void isElementDisplayed(String locator,String... values){
        searchToElement(locator,values).isDisplayed();
    }

    public void isSelectedElement(String locator,String... values){
        searchToElement(locator,values).isSelected();
    }

    public List<WebElement> getListElement(String locator,String... values){
        return driver.findElements(getByLocator(castToParameter(locator,values)));
    }

    public void switchToIframe(String locator,String...values){
        driver.switchTo().frame(castToParameter(locator,values));
    }

    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public String getTitles(){
        return driver.getTitle();
    }

    public void clickByJs(String locator,String...values){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",searchToElement(locator,values));
    }


    public WebDriver switchToId(String id){
        return driver.switchTo().window(id);
    }

    public void switchToWindowTabs(String titleExpected){
        sleepInTime(1);
        Set<String> allTabs = getWindowHandles();
        if(allTabs.size() > 1){
            for (String tab:allTabs) {
                switchToId(tab);
                if(getTitles().equals(titleExpected)){
                    break;
                }
            }
        }
    }

    public void switchToWindowById(){
        String idTabPresent = getWindowHandle();
        Set<String> allTabid = getWindowHandles();
        for (String tab:allTabid) {
            if(!tab.equals(idTabPresent)){
                switchToId(tab);
            }
        }
    }

    public void sleepInTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int randomNum(int num){
        Random rand = new Random();
        int random = rand.nextInt(1000);
        return random;
    }
}
