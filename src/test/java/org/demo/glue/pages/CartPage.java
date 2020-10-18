package org.demo.glue.pages;

import org.demo.driver_manager.DriverManager;
import org.demo.enums.EnumConditions;
import org.demo.util.LibWebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private static final By titleCestaSelector = By.xpath("//title[text()='Cesta']");
    private static final By numberOfArticlesSelector = By.xpath("(//div[@data-id='tile-title'])[1]/h2");
    private static final By articleOnCartSelector = By.xpath("//div[@data-id='article-group']//span/a");
    private static final By articlesSizeSelector = By.xpath("(//div[@data-id='article-group']//span)[4]");

    private WebDriver driver;

    LibWebActions libWebActions = new LibWebActions();

    public CartPage() {
        driver = DriverManager.getCurrentDriver();
    }

    public boolean isCestaPageDisplayed() {
        return libWebActions.isElementDisplayed(titleCestaSelector);
    }

    public String getArticlesNumOnCart() {
        libWebActions.waitForCondition(numberOfArticlesSelector, EnumConditions.VISIBILITY_OF);
        return driver.findElement(numberOfArticlesSelector).getText().replaceAll("[^-?0-9]+", "");
    }

    public boolean isArticleOnCartDisplayed(String product) {
        return driver.findElement(articleOnCartSelector).getText().contains(product);
    }

    public String getSizeFromArticleOnCart() {
       return driver.findElement(articlesSizeSelector).getText().replaceAll("[^-?0-9]+", "");
    }

}
