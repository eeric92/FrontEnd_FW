package org.demo.glue.steps;

import cucumber.api.java.en.Then;
import org.demo.driver_manager.DriverManager;
import org.demo.glue.pages.CartPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {

    WebDriver driver;

    CartPage cartPage = new CartPage();

    public CartSteps() {
        driver = DriverManager.getCurrentDriver();
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
