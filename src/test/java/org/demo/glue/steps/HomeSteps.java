package org.demo.glue.steps;

import cucumber.api.java.en.Given;
import org.demo.driver_manager.DriverManager;
import org.demo.glue.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomeSteps {

    WebDriver driver;

    HomePage homePage = new HomePage();

    public HomeSteps() {
        driver = DriverManager.getCurrentDriver();
    }

    @Given("^the user accepts cookies$")
    public void the_user_accepts_cookies() {
        homePage.clickAcceptCookies();
    }

    @Given("^the home page is displayed$")
    public void the_home_page_is_displayed() {
        Assert.assertTrue("The Home page is not displayed", homePage.isHomePageTitleDisplayed());
    }

    @Given("^the user introduces '(.*)' on search bar on Home page$")
    public void the_user_introduces_on_search_bar_on_Home_page(String product) {
        homePage.introduceProductOnSearchBar(product);
    }

}
