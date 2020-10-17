package org.demo.glue.pages;

import org.demo.driver_manager.DriverManager;
import org.demo.util.LibWebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private static final By buttonAnadirCestaSelector = By.xpath("//button[@aria-label='Añadir a la cesta' and @type='button']");
    private static final By dropdownSizeSelector = By.id("picker-trigger");
    private static final String dropdownOptionLocator = "//form[@name='size-picker-form']/div/div[%s]";
    private static final By cartButtonSelector = By.xpath("//div[@class='z-navicat-header_navToolItem z-navicat-header_navToolItem-bag']");

    private WebDriver driver;

    LibWebActions libWebActions = new LibWebActions();

    public ProductPage() {
        driver = DriverManager.getCurrentDriver();
    }

    public boolean isProductScreenDisplayed() {
        return libWebActions.isElementDisplayed(buttonAnadirCestaSelector);
    }

    public void selectShoeSize(String option) {
        libWebActions.clickElement(dropdownSizeSelector);
        libWebActions.clickElement(By.xpath(String.format(dropdownOptionLocator, option)));
    }

    public void clickOnAddToCartButton() {
        libWebActions.clickElement(buttonAnadirCestaSelector);
    }

    public void clickOnCart() {
        libWebActions.clickElement(cartButtonSelector);
    }
}
