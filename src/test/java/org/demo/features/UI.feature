@CRT
Feature: Add product to cart

  Background:
    Given the home page is displayed
    And the user accepts cookies

  @TC001
  Scenario: Add shoe to Cart using search bar
    Given the user introduces 'Adidas zapatillas' on search bar on Home page
    And the Results screen is displayed with 'Adidas zapatillas' at search
    When the user selects 'ULTRABOOST SUMMER.RDY SHOES' item on Results page
    Then the Product screen is displayed
    When the user selects '2' option on size dropdown
    And the user clicks on 'Add to Cart'
    And the user clicks on 'Cart'
    Then the Cart screen is displayed
    And the num of articles in the cart is '1'
    And the article 'ULTRABOOST SUMMER.RDY SHOES' is displayed on the Cart
    And the size of the article is '40'




