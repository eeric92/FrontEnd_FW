package org.demo.glue.pages;

import org.demo.driver_manager.DriverManager;
import org.demo.util.LibWebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {

    private static final By resultsSearchTitleSelector = By.xpath("//h1[@class='cat_searchTerm-2xjht cat_main-1dxBH']");
    private static final String selectResultsElementLocator = "//div[@class='qMZa55 SQGpu8 iOzucJ JT3_zV DvypSJ']//h3[contains(text(),'%s')]";

    private WebDriver driver;

    LibWebActions libWebActions = new LibWebActions();

    public ResultsPage() {
        driver = DriverManager.getCurrentDriver();
    }

    public String isResultsScreenSearchDisplayed() {
        return driver.findElement(resultsSearchTitleSelector).getText();
    }

    public void clickOnResultsElement(String product) {
        libWebActions.clickElement(By.xpath(String.format(selectResultsElementLocator, product)));
    }

}
