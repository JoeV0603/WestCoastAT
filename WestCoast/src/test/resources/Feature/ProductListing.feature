Feature: Product Listing

  Scenario: Product listing page load
    Given I navigate to the product listing page
    Then the product listing page should load successfully

  Scenario: Product details display
    Given I navigate to the product listing page
    When I view the product details
    Then the product details should be displayed correctly

  Scenario: Pagination
    Given I navigate to the product listing page
    When I navigate to the next page
    Then the next set of products should be displayed
    
  Scenario: Product Image and Links
    Given I navigate to the product listing page
    Then each product should have an image and a link to the product details