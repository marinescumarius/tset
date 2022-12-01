package marius.tset.com.pageobjects;

import marius.tset.com.data.PriceComponents;
import marius.tset.com.utils.waits.WDWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import marius.tset.com.utils.webelement.WEUtils;

import java.text.DecimalFormat;
import java.util.List;

public class VueAppHomePage extends BasePage {
    @FindBy(id = "base-check-icon")
    private WebElement baseCheckIcon;
    @FindBy(id = "BasePrice")
    private WebElement basePrice;
    @FindBy(id = "base-value-input")
    private WebElement inputBasePrice;
    @FindBy(id = "base-edit-icon")
    private WebElement editBasePrice;
    @FindBy(xpath = "//span[text()='internal surcharge']/following::i[contains(@class, 'fas fa-trash-alt')]")
    private WebElement removeInternalComponent;
    @FindBy(xpath = "//span[text()='storage surcharge']/following::i[contains(@class, 'fas fa-pencil-alt')]")
    private WebElement modifyStorageComponent;
    @FindBy(id = "ghost-label-input")
    private WebElement labelInputField;
    @FindBy(id = "ghost-value-input")
    private WebElement valueInputField;
    @FindBy(id = "ghost-check-icon")
    private WebElement ghostCheckIcon;
    @FindBy(xpath = "//span[text()='internal surcharge']")
    private WebElement internalSurcharge;
    @FindBy(xpath = "//span[text()='storage surcharge']")
    private WebElement storageSurcharge;
    @FindBy(xpath = "//div[contains(@class, 'text-right mr-16 pr-2')]//span[contains(@class, 'font-bold')]")
    private WebElement expectedResult;

    public WebElement getModifyStorageComponent() {
        return modifyStorageComponent;
    }

    public WebElement getStorageSurcharge() {
        return storageSurcharge;
    }

    public WebElement getInternalSurcharge() {
        return internalSurcharge;
    }

    public WebElement getGhostCheckIcon() {
        return ghostCheckIcon;
    }

    public WebElement getRemoveInternalComponent() {
        return removeInternalComponent;
    }

    public WebElement getValueInputField() {
        return valueInputField;
    }

    public WebElement getBaseCheckIcon() {
        return baseCheckIcon;
    }

    public WebElement getExpectedResult() {
        return expectedResult;
    }

    public VueAppHomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getInputBasePrice() {
        return inputBasePrice;
    }

    public WebElement getLabelInputField() {
        return labelInputField;
    }

    public WebElement getBasePrice() {
        return basePrice;
    }

    public WebElement getEditBasePrice() {
        return editBasePrice;
    }

    public void editTheBasePrice() {
        WDWait.waitForElementToBeVisible(driver, getBasePrice());
        WEUtils.moveToElement(driver, getBasePrice());
        getEditBasePrice().click();
        WEUtils.doubleClick(driver, getInputBasePrice());
        getInputBasePrice().sendKeys(String.valueOf(PriceComponents.BASE.getValue()));
        getBaseCheckIcon().click();
    }

    public void addComponent(String component, double value) {
        WDWait.waitForElementToBeClickable(driver, getLabelInputField());
        WEUtils.doubleClick(driver, getLabelInputField());
        getLabelInputField().sendKeys(component);
        WEUtils.doubleClick(driver, getValueInputField());
        getValueInputField().sendKeys(String.valueOf(value));
        getGhostCheckIcon().click();
    }

    public void removeComponent(WebElement webElementToHoverOver, WebElement removeIcon) {
        WDWait.waitForElementToBeVisible(driver, webElementToHoverOver);
        WEUtils.moveToElement(driver, webElementToHoverOver);
        removeIcon.click();
    }

    public String calculateTheTotalValueOfComponents() {
        final DecimalFormat decfor = new DecimalFormat("0.00");
        List<WebElement> results = driver.findElements(By.xpath("//ul//div//div//div"));
        double sum = 0.00;
        for (WebElement el : results) {
            sum = sum + Double.parseDouble(el.getText());
        }
        return decfor.format(sum);
    }

//    public void modifyComponent(WebElement webElementToHoverOver, WebElement pencilIcon) {
//        WDWait.waitForElementToBeVisible(driver, webElementToHoverOver);
//        WEUtils.moveToElement(driver, webElementToHoverOver);
//        WDWait.waitForElementToBeClickable(driver, pencilIcon);
//        pencilIcon.click();
//    }
}
