Feature: API Testing

  Scenario: Generate OAuth2.0 Token
    Given I request an OAuth2.0 token
    Then the response status code should be 200
    And the response should contain a token

  Scenario: Update Order
    Given I update the shipment details and order status
    Then the response status code should be 200
    And the response should confirm the update

  Scenario: Add Product
    Given I add a new product
    Then the response status code should be 201
    And the response should confirm the product was added

  Scenario: Update Product
    Given I update an existing product
    Then the response status code should be 200
    And the response should confirm the product was updated

  Scenario: Get Tags
    Given I get all tags from the network
    Then the response status code should be 200
    And the response should contain tags

  Scenario: Get Coupons
    Given I get all coupons from the network
    Then the response status code should be 200
    And the response should contain coupons

  Scenario: Create Customer
    Given I create a new customer
    Then the response status code should be 201
    And the response should confirm the customer was created

  Scenario: Update Customer
    Given I update an existing customer
    Then the response status code should be 200
    And the response should confirm the customer was updated