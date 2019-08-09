package com.sda.awesome.pages;

import com.sda.awesome.WaitTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/h1")
    private WebElement searchHeader;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a")
    private WebElement cart;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")
    private WebElement shopElement;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/div/div/div/p[2]/a/span")
    public WebElement checkoutButton;

    public String getSearchHeaderText() {
        System.out.println(searchHeader.getText());
        return searchHeader.getText();
    }

    public WebElement getSearchHeader() {
        return searchHeader;
    }

    public WebElement getCart() {
        return cart;
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getAddToCartButton() { return addToCartButton; }

    public void getCartDisplayed(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(cart).build().perform();
    }

    public boolean checkIfCheckoutButtonPresent() {
        return checkoutButton.isDisplayed();
    }

    public void getElementDisplayed(WebDriver driver) {
        Actions builder = new Actions(driver);
        builder.moveToElement(shopElement).build().perform();
    }




}
