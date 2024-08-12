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

Scenario: New arrivals section
    Given I am on the homepage
    Then the new arrivals section should be displayed

Scenario: Roast level section
    Given I am on the homepage
    Then the roast level section should be displayed

Scenario: Special offers section
    Given I am on the homepage
    Then the special offers section should be displayed

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