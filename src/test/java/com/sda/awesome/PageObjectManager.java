package com.sda.awesome;

import com.sda.awesome.pages.CheckoutPage;
import com.sda.awesome.pages.ConfirmBuyPage;
import com.sda.awesome.pages.MainShopPage;
import com.sda.awesome.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    private WebDriver driver;
    private MainShopPage mainShopPage;
    private SearchResultPage searchResultPage;
    private ConfirmBuyPage confirmBuyPage;
    private CheckoutPage checkoutPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainShopPage getMainShopPage() {
        if(mainShopPage == null) {
            mainShopPage = PageFactory.initElements(driver, MainShopPage.class);
        }
        return mainShopPage;
    }

    public SearchResultPage getSearchResultPage() {
        if(searchResultPage == null) {
            searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        }
        return searchResultPage;
    }

    public ConfirmBuyPage getConfirmBuyPage() {
        if(confirmBuyPage == null) {
            confirmBuyPage = PageFactory.initElements(driver, ConfirmBuyPage.class);
        }
        return confirmBuyPage;
    }

    public CheckoutPage getCheckoutPage() {
        if(checkoutPage == null) {
            checkoutPage = PageFactory.initElements(driver,CheckoutPage.class);
        }
        return checkoutPage;
    }

}
