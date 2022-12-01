package marius.tset.com.utils.webelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WEUtils {

    public static boolean isDisplayed ( WebElement element) {
        return element.isDisplayed();
    }

    public static boolean clickOnButton (WebElement element) {
        try {
            element.click();
            return true;

        }catch (Exception e) {
            return false;
        }
    }

    public static void doubleClick(WebDriver driver, WebElement webElement){
        Actions action = new Actions(driver);
        try{
            action.doubleClick(webElement).perform();
        }
        catch ( Exception e) {
            System.out.println("Element not visible");
        }

    }

    public static  void moveToElement(WebDriver driver, WebElement webElement) {
        Actions action = new Actions(driver);
        try{
            action.moveToElement(webElement).perform();
        }
        catch ( Exception e) {
            System.out.println("Element not visible");
        }

    }

}
