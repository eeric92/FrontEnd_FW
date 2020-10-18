package org.demo.glue.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.demo.driver_manager.DriverManager;
import org.demo.glue.pages.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ProductSteps {

    WebDriver driver;

    ProductPage productPage = new ProductPage();

    public ProductSteps() {
        driver = DriverManager.getCurrentDriver();
    }

    @Then("^the Product screen is displayed$")
    public void the_Product_screen_is_displayed() {
        Assert.assertTrue("The Product screen is not displayed", productPage.isProductScreenDisplayed());
    }

    @When("^the user selects '(.*)' option on size dropdown$")
    public void the_user_selects_option_on_size_dropdown(String option) {
        productPage.selectShoeSize(option);
    }

    @When("^the user clicks on 'Add to Cart'$")
    public void the_user_clicks_on_Add_to_Cart() {
        productPage.clickOnAddToCartButton();
    }

    @When("^the user clicks on 'Cart'$")
    public void the_user_clicks_on_Cart() {
        productPage.clickOnCart();
    }

}
