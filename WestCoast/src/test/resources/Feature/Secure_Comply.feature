Feature: Security and Compliance

  Scenario: Account lockout after multiple failed login attempts
    Given I am on the login page
    When I enter incorrect credentials multiple times
    Then my account should be locked out

  Scenario: Password reset email validation
    Given I request a password reset
    When I check my email
    Then I should receive a password reset email

  Scenario: Password reset link expiry
    Given I request a password reset
    When I wait for the reset link to expire
    Then I should not be able to use the expired link to reset my password

  Scenario: Email Change Verification
    Given I request to change my email address
    When I check my old email
    Then I should receive a verification email
    When I click the verification link
    Then my email address should be updated

  Scenario: Secure payment gateway integration
    Given I am on the payment page
    When I enter valid payment details
    Then the payment should be processed securely

  Scenario: Data encryption at rest
    Given I access sensitive data
    Then the data should be encrypted at rest

  Scenario: Audit logs for security events
    Given a security event occurs
    When I check the audit logs
    Then the event should be recorded in the logs

  Scenario: GDPR Compliance
    Given I request my data for GDPR compliance
    When I check the response
    Then my data should be provided or deleted as per GDPR

  Scenario: PCI DSS Compliance for Payment Processing
    Given I am on the payment page
    When I enter payment details
    Then the payment process should be compliant with PCI DSS standards
