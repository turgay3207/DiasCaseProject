@hepsiburada
Feature: HepsiBurada UI Test

  Scenario: TC01 User adds the most expensive Apple 13.2-inch tablet to the cart and verifies price
    Given the user navigates to "https://www.hepsiburada.com/"
    When the user goes to Tum Kategoriler -> Elektronik -> Tablet category
    And the user filters by brand Apple and screen size inch
    And the user selects the most expensive product from the filtered results
    And the user clicks the "Sepete Ekle" button on the product detail page
    Then the user verifies that the product is added to the cart
    And the user verifies that the price in the cart matches the product detail page