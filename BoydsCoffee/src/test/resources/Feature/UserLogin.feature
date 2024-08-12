Feature: User Login

  Scenario: Valid User Login
    Given User navigates to the login page
    When User enters valid credentials
    Then User should be logged in successfully

  Scenario: Invalid User Login
    Given User navigates to the login page
    When User enters invalid credentials
    Then User should see an error message

 Scenario: Incorrect Password
    Given User navigates to the login page
    When User enters incorrect password
    Then User should see an error message1

  Scenario: Login with empty username
    Given User navigates to the login page
    When User enters empty username
    Then User should see a validation message

  Scenario: Login with empty password
    Given User navigates to the login page
    When User enters empty password
    Then User should see a validation message1

  Scenario: Forgot Password
    Given User navigates to the login page
    When User clicks on Forgot Password link
    Then User should be redirected to the Forgot Password page