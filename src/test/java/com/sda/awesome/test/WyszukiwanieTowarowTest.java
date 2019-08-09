package com.sda.awesome.test;

import com.sda.awesome.PageObjectManager;
import com.sda.awesome.WaitTools;
import com.sda.awesome.pages.WomenPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class WyszukiwanieTowarowTest {

    private WebDriver driver;
    private PageObjectManager manager;

    public WyszukiwanieTowarowTest() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver0240.exe");
        driver = new FirefoxDriver();
        manager = new PageObjectManager(driver);
    }

    @Test
    public void wyszukajTowaryTest() throws InterruptedException {
        driver.get("http://automationpractice.com");

        manager.getMainShopPage().searchFor("dress");
        manager.getMainShopPage().clickSearchButton();

        WebElement element = manager.getSearchResultPage().getSearchHeader();

        WaitTools.isElementVisible(driver, element);
        String result = manager.getSearchResultPage().getSearchHeaderText();
        assertTrue(result.contains("SEARCH"));

        manager.getSearchResultPage().getElementDisplayed(driver);

        WaitTools.isElementVisible(driver, manager.getSearchResultPage().getAddToCartButton());
        manager.getSearchResultPage().clickAddToCartButton();

        WaitTools.isElementVisible(driver, manager.getConfirmBuyPage().getContinueShoppingButton());
        manager.getConfirmBuyPage().clickContinueButton();

        WaitTools.isElementVisible(driver, manager.getSearchResultPage().getCart());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)");

        manager.getSearchResultPage().getCartDisplayed(driver);
        WaitTools.isElementVisible(driver, manager.getSearchResultPage().checkoutButton);
        assertTrue(manager.getSearchResultPage().checkIfCheckoutButtonPresent());

        manager.getCheckoutPage().clickCheckoutPage();
        assertTrue(WaitTools.isElementVisible(driver, manager.getCheckoutPage().plus));
        manager.getCheckoutPage().clickPlus();

        assertTrue(WaitTools.isElementAttributeUpdated(driver, manager.getCheckoutPage().quantityLabel, "value", "2"));

        JavascriptExecutor jz = (JavascriptExecutor) driver;
        jz.executeScript("window.scrollBy(0,500)");

        manager.getCheckoutPage().clickProceedToCheckoutButton();

        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void womenPageTest() throws InterruptedException {
        driver.get("http://automationpractice.com");
        WomenPage womenPage = new WomenPage(driver);
        womenPage.womenPageLink.click();
        System.out.println(womenPage.catalogTitle.isDisplayed());
        womenPage.checkboxTops.click();
        assertTrue(womenPage.checkboxTops.isSelected());
        womenPage.checkboxSize.click();
        assertTrue(womenPage.checkboxSize.isSelected());
        womenPage.checkboxNew.click();
        assertTrue(womenPage.checkboxNew.isSelected());

        JavascriptExecutor jc = (JavascriptExecutor) driver;
        jc.executeScript("window.scrollBy(0,400)");

        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(womenPage.rightSlider, -170, 0).build();
        action.perform();

        TimeUnit.SECONDS.sleep(3);

    }

//    @After
//    public void shutDown() {
//        driver.quit();
//    }

}
