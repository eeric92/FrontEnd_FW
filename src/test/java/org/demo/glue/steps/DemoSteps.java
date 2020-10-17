package org.demo.glue.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.demo.driver_manager.DriverManager;
import org.demo.glue.pages.CartPage;
import org.demo.glue.pages.HomePage;
import org.demo.glue.pages.ProductPage;
import org.demo.glue.pages.ResultsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DemoSteps {

    WebDriver driver;

    HomePage homePage = new HomePage();
    ResultsPage resultsPage = new ResultsPage();
    CartPage cartPage = new CartPage();
    ProductPage productPage = new ProductPage();

    public DemoSteps() {
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

    @Given("^the Results screen is displayed with '(.*)' at search$")
    public void the_Results_screen_is_displayed_with_search(String product) {
        Assert.assertEquals("Results screen is not displayed with text " + product, product,
                resultsPage.isResultsScreenSearchDisplayed());
    }

    @When("^the user selects '(.*)' item on Results page$")
    public void the_user_selects_item_on_Results_page(String product) {
        resultsPage.clickOnResultsElement(product);
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

    @Then("^the Cart screen is displayed$")
    public void the_Cart_screen_is_displayed() {
        Assert.assertTrue("The Cart screen is not displayed", cartPage.isCestaPageDisplayed());
    }

    @Then("^the num of articles in the cart is '(.*)'$")
    public void the_num_of_articles_in_the_cart_is(String articles) {
        Assert.assertEquals("The total number of articles not matches", articles,
                cartPage.getArticlesNumOnCart());
    }

    @Then("^the article '(.*)' is displayed on the Cart$")
    public void the_article_is_displayed_on_the_Cart(String product) {
        Assert.assertTrue("The article is not displayed on the Cart",
                cartPage.isArticleOnCartDisplayed(product));
    }

    @Then("^the size of the article is '(.*)'$")
    public void the_size_of_the_article_is(String size) {
        Assert.assertEquals("The size of the article not matches", size,
                cartPage.getSizeFromArticleOnCart());
    }


}
