package com.sda.awesome.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    public WebElement womenPageLink;
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div[1]/div[2]/p")
    public WebElement catalogTitle;
    @FindBy(id = "layered_category_4")
    public WebElement checkboxTops;
    @FindBy(id = "layered_id_attribute_group_2")
    public WebElement checkboxSize;

    public WomenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
