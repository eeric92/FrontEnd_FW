package org.demo.glue.pages;

import org.demo.driver_manager.DriverManager;
import org.demo.enums.EnumConditions;
import org.demo.util.LibWebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private static final By homePageTitleSelector = By.xpath("//title[text()='Zapatos y ropa online | La mejor selección en Zalando']");
    private static final By acceptButtonCookies = By.id("uc-btn-accept-banner");
    private static final By searchBarSelector = By.xpath("//input[@type='search']");

    private WebDriver driver;

    LibWebActions libWebActions = new LibWebActions();

    public HomePage() {
        driver = DriverManager.getCurrentDriver();
    }

    public boolean isHomePageTitleDisplayed() {
        return libWebActions.isElementDisplayed(homePageTitleSelector);
    }

    public void clickAcceptCookies() {
        libWebActions.clickElement(acceptButtonCookies);
    }

    public void introduceProductOnSearchBar(String product) {
        libWebActions.waitForCondition(searchBarSelector, EnumConditions.VISIBILITY_OF);
        final WebElement searchField = driver.findElement(searchBarSelector);
        searchField.sendKeys(product);
        searchField.sendKeys(Keys.ENTER);
    }


}
