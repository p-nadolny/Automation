package com.sda.awesome.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/div/div/div/p[2]/a/span/i")
    private WebElement checkoutCartLink;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/div/a[2]/span/i")
    public WebElement plus;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/input[2]")
    public WebElement quantityLabel;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/ul/li[1]/span")
    public WebElement summaryLabel;

    public String getTextFromSummaryLabel() {
        return summaryLabel.getText();
    }


    public void clickCheckoutPage(){
        checkoutCartLink.click();
    }
    public void clickPlus() {
        plus.click();
    }


}
