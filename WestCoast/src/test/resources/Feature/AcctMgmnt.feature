Feature: Account Management

  Scenario: Update Profile Information
    Given the user is logged in
    When the user updates their profile information
    Then the profile information should be updated successfully

  Scenario: Change Password
    Given the user is logged in
    When the user changes their password
    Then the password should be changed successfully

  Scenario: Save payment methods
    Given the user must be logged in
    When the user saves a new payment method
    Then the payment method should be saved successfully

  Scenario: Logout
    Given the user must be logged in
    When the user logs out
    Then the user should be logged out successfully

  Scenario: View account details
    Given the user must be logged in
    When the user views their account details
    Then the account details should be displayed correctly