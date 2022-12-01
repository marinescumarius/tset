package marius.tset.com.test;

import marius.tset.com.data.PriceComponents;
import marius.tset.com.pageobjects.VueAppHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import marius.tset.com.utils.webelement.WDUtlis;

public class VueAppHomePageTests extends BaseTest {

    @Test(description = "this test case validates the right page has been accessed")
    public void checkThePageTitle() {

        Assert.assertTrue((WDUtlis.getTitle(driver)).contains("Vite"), "The title does not contain Vite");
    }

    @Test(description = "this test case covers flow scenario 1, modifying BasePrice and validating results")
    public void editTheBasePriceTest() {
        VueAppHomePage homepage = new VueAppHomePage(driver);
        homepage.editTheBasePrice();
        Assert.assertTrue(homepage.getExpectedResult().getText().equals(homepage.calculateTheTotalValueOfComponents()), "The Expected Results does not match with the basePrice value");
    }

    @Test(description = "this test case covers flow scenarios 2 and 3, adding all of the components and validate results, as well as remove Internal Surcharge and revalidate results")
    public void addAndRemoveComponents() {
        VueAppHomePage homePage = new VueAppHomePage(driver);
        homePage.editTheBasePrice();
        homePage.addComponent(PriceComponents.ALLOY.getComponent(), PriceComponents.ALLOY.getValue());
        homePage.addComponent(PriceComponents.SCRAP.getComponent(), PriceComponents.SCRAP.getValue());
        homePage.addComponent(PriceComponents.INTERNAL.getComponent(), PriceComponents.INTERNAL.getValue());
        homePage.addComponent(PriceComponents.EXTERNAL.getComponent(), PriceComponents.EXTERNAL.getValue());
        homePage.addComponent(PriceComponents.STORAGE.getComponent(), PriceComponents.STORAGE.getValue());
        Assert.assertTrue(homePage.getExpectedResult().getText().equals(homePage.calculateTheTotalValueOfComponents()), "The Expected Results do not match with the output value");
        homePage.removeComponent(homePage.getInternalSurcharge(), homePage.getRemoveInternalComponent());
        Assert.assertTrue(homePage.getExpectedResult().getText().equals(homePage.calculateTheTotalValueOfComponents()), "The Expected Results do not match with the output value");
    }
}
