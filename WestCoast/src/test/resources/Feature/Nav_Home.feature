Feature: Navigation and Homepage

Scenario: Homepage Load
    Given I am on the homepage
    Then the homepage should load successfully

Scenario: Navigation Links
    Given I am on the homepage
    When I click on the navigation links
    Then the corresponding pages should load successfully

Scenario: Featured products section
    Given I am on the homepage
    Then the featured products section should be displayed

Scenario: Shop Ground Coffee section
    Given I am on the homepage
    Then Shop ground coffee section should be displayed

Scenario: Shop Whole Bean section
    Given I am on the homepage
    Then Shop whole bean section should be displayed

Scenario: Whole Bean Bulk section
    Given I am on the homepage
    Then Whole bean bulk section should be displayed

Scenario: Website responsiveness
    Given I am on the homepage
    When I resize the browser window
    Then the website should adjust accordingly

Scenario: Website speed
    Given I am on the homepage
    Then the website should load within acceptable time

Scenario: Design consistency
    Given I am on the homepage
    Then the design should be consistent across pages

Scenario: Social media integration
    Given I am on the homepage
    Then the social media links should be functional