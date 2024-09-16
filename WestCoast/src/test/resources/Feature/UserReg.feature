Feature: User Registration

  Scenario: Register a new user with valid details
    Given User is on registration page
    When User enters valid registration details
    Then User registration should be successful

  Scenario: Register a new user with invalid email
    Given User is on registration page
    When User enters invalid email
    Then User should see an email validation error

  Scenario: Register a new user with short password
    Given User is on registration page
    When User enters a short password
    Then User should see a password validation error

    Scenario: Register a new user with strong password
    Given User is on registration page
    When User enters a strong password
    Then User should see a password validation text

  Scenario: Register a new user with existing email
    Given User is on registration page
    When User enters an email that is already registered
    Then User should see an email already registered error    