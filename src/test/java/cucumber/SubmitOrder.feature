@tag
  Feature: purchase the order from Ecommerce Website
    Background:
      Given I landed on Ecommerce Page

    @Regressionn
    Scenario Outline: Positive Test of submitting the order
      Given logged in with username <Name> and password <Password>
      When I add product <productName> to cart
      And Checkout <productName> and submit the order
      Then "THANKYOU FOR THE ORDER." confirmation message is displayed on confirmationpage



      Examples:
        | Name             | Password | productName   |
        |drdoom@yopmail.com|Test@123  |ADIDAS ORIGINAL|
