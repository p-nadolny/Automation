package com.sda.awesome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainShopPage {

    @FindBy(xpath="//*[@id=\"search_query_top\"]")
    private WebElement searchBox;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[2]/form/button")
    private WebElement searchButton;

    public void searchFor(String content) {
        searchBox.sendKeys(content);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
