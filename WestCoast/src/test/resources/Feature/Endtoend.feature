Feature: End to End testing

  Scenario: "Decaf Colombian Whole Bean Coffee: 5 lb." - Order confirmation
  
  
    Given the user logs into the website
    
    And User navigates to shop all tab
    
    Then the user adds Decaf Colombian Whole Bean Coffee 5 lb to the cart

    And the final check out is done with order confirmation
