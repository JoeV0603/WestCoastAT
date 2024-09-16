Feature: Product browse and search functionalities

  Scenario: Verify product browsing functionality
    Given I am on the home page
    When I navigate to the product browsing section and should see a list of products
    Then I should be able to click a product and see the product details page

  Scenario: Verify product search functionality with a valid search query
    Given I am on the home page
    When I navigate to the product browsing section and search for Ground Coffee
    Then I should see products related to Ground Coffee

  Scenario: Verify product search functionality with an invalid search query
    Given I am on the home page
    When I navigate to the product browsing section and search for Juice
    Then I should see a message indicating no results found

  Scenario: Verify product sorting functionality
    Given I am on the product browsing page
    When I sort products by price
    Then the products should be sorted by price in ascending order

  Scenario: Verify product filtering functionality
    Given I am on the product browsing page
    When I apply a filter for roast level
    Then I should see only products from the selected roast level