Feature: Customer Service

Scenario: Access customer service page
  Given User is on the homepage
  When User navigates to the customer support page
  Then Customer support page should be displayed

Scenario: Contact customer service through email
  Given User is on the customer support page
  Then User should see the customer service email id

Scenario: Contact customer service through phonenumber
  Given User is on the customer support page
  Then User should see the customer service phonenumber

Scenario: Access service location
  Given User is on the customer support page
  Then User should see the service location successfully

Scenario: Contact Us form
  Given User is on the customer support page
  When User submits a query through the Contact Us form
  Then Contact Us form confirmation message should be displayed

Scenario: Receive contact us form confirmation email
  Given User is on the customer support page
  When User submits a query through the Contact Us form
  Then Contact Us form confirmation email should be received