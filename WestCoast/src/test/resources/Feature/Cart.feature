Feature: Cart Functionality

Scenario: View cart
    Given the user is on the cart page
    When the user views the cart
    Then the cart should display the correct items

Scenario: Verify adding a product to cart from product detail page
    Given the user is on a product detail page
    When the user adds the product to the cart
    Then the cart should contain the added product from detail page

Scenario: Verify adding a product to cart from product listing page
    Given the user is on the product listing page
    When the user adds a product to the cart
    Then the cart should contain the added product from listing page

Scenario: Verify quantity increase in cart
    Given the user has a product in the cart
    When the user increases the quantity of the product
    Then the cart should reflect the increased quantity

Scenario: Verify quantity decrease in cart
    Given the user has a product in the cart
    When the user decreases the quantity of the product
    Then the cart should reflect the decreased quantity

Scenario: Verify cart persistence across sessions
    Given the user has a product in the cart
    When the user logs out and logs back in
    Then the cart should still contain the same product

Scenario: Apply Discount Code
    Given the user has a product in the cart
    When the user applies a discount code
    Then the cart should reflect the discount
    
Scenario: Verify removing a product from cart
    Given the user has a product in the cart
    When the user removes the product from the cart
    Then the cart should be empty

Scenario: Verify adding multiple products to cart
    Given the user is on the products listing page
    When the user adds multiple products to the cart
    Then the cart should contain all the added products

Scenario: Verify adding products to cart from wishlist
    Given the user has products in the wishlist
    When the user adds a product from the wishlist to the cart
    Then the cart should contain the added product from wishlist