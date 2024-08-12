Feature: Product Details

  Scenario: Verify product description accuracy
    Given the user is on the product details page
    Then the product description should be accurate

  Scenario: Verify product availability
    Given the user is on the product details page
    Then the product availability status should be displayed

  Scenario: Verify related products
    Given the user is on the product details page
    Then the related products should be displayed

  Scenario: Verify product price display
    Given the user is on the product details page
    Then the product price should be displayed

  Scenario: Verify multiple product images
    Given the user is on the product details page
    Then multiple product images should be displayed

  Scenario: Verify product SKU display
    Given the user is on the product details page
    Then the product SKU should be displayed
