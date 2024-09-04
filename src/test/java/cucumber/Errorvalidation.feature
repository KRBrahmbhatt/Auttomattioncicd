@tag
  Feature: Error Validation

    @Errorvalidation
    Scenario Outline: Title of your Scenario outline
      Given I landed on Ecommerce Page
      When logged in with username <Name> and password <Password>
      Then "Incorrect email or password." message is displayed


      Examples:
         | Name             | Password |
        |drdoom@yopmail.com|Test@1  |
