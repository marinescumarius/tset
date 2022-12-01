package marius.tset.com.test;

import marius.tset.com.data.Constants;
import marius.tset.com.utils.webelement.WDUtlis;
import marius.tset.com.utils.webdriver.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        System.out.println("-----Before Test-----");
        driver = SeleniumDriver.instantiateWebDriver();
        Assert.assertNotNull(driver, "Unable to create the driver");
        WDUtlis.navigateTo(driver, Constants.BASE_URL);

    }

    @AfterTest
    public void tearDown() {
        try {
            driver.close();
            driver.quit();
        } catch ( Exception e ) {
            System.out.println("Unable to close/quit the driver");
        }
    }


}
