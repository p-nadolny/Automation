package com.sda.awesome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmBuyPage {

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span")
    private WebElement continueShoppingButton;

    public void clickContinueButton() {
        continueShoppingButton.click();
    }

    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

}
