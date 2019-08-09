package com.sda.awesome;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTools {

    public static boolean isElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public static boolean isElementAttributeUpdated(WebDriver driver, WebElement element, String attribute, String valueOfAttribute) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.attributeToBe(element, attribute, valueOfAttribute));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
