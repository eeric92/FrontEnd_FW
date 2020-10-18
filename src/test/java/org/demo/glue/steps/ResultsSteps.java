package org.demo.glue.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.demo.driver_manager.DriverManager;
import org.demo.glue.pages.ResultsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ResultsSteps {

    WebDriver driver;

    ResultsPage resultsPage = new ResultsPage();

    public ResultsSteps() {
        driver = DriverManager.getCurrentDriver();
    }

    @Given("^the Results screen is displayed with '(.*)' at search$")
    public void the_Results_screen_is_displayed_with_search(String product) {
        Assert.assertEquals("Results screen is not displayed with text " + product, product,
                resultsPage.isResultsScreenSearchDisplayed());
    }

    @When("^the user selects '(.*)' item on Results page$")
    public void the_user_selects_item_on_Results_page(String product) {
        resultsPage.clickOnResultsElement(product);
    }

}
