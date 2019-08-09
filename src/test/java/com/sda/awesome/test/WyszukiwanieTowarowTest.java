package com.sda.awesome.test;

import com.sda.awesome.PageObjectManager;
import com.sda.awesome.WaitTools;
import com.sda.awesome.pages.WomenPage;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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

        manager.getSearchResultPage().clickinAddToCartButton();

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



        TimeUnit.SECONDS.sleep(5);
    }

//    @Test
//    public void womenPageTest() {
//        driver.get("http://automationpractice.com");
//        WomenPage womenPage = new WomenPage(driver);
//        womenPage.womenPageLink.click();
//        System.out.println(womenPage.catalogTitle.isDisplayed());
//        womenPage.checkboxTops.click();
//        assertTrue(womenPage.checkboxTops.isSelected());
//        womenPage.checkboxSize.click();
//        assertTrue(womenPage.checkboxSize.isSelected());
//
//    }

//    @After
//    public void shutDown() {
//        driver.quit();
//    }

}
