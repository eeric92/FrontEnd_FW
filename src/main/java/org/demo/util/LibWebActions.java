package org.demo.util;

import org.demo.driver_manager.DriverManager;
import org.demo.enums.EnumConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibWebActions {

    private WebDriver driver;
    private static final int TIMEOUT = 20;

    public LibWebActions() {
        driver = DriverManager.getCurrentDriver();
    }

    public void clickElement(final By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, TIMEOUT);

        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
        element.click();
    }

    public boolean isElementDisplayed(final By by) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, TIMEOUT);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForCondition(By objectName, EnumConditions elementConditions) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, TIMEOUT);

        switch (elementConditions) {
            case ELEMENT_TO_BE_CLICKABLE:
                webDriverWait.until(ExpectedConditions.elementToBeClickable(objectName));
                break;
            case VISIBILITY_OF:
                webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(objectName)));
                break;
            case INVISIVILITY_OF:
                webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(objectName)));
                break;
            default:
                System.out.println("Parameter not suported");
        }
    }

}
