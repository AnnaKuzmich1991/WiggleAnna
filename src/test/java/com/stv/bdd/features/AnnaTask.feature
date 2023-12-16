Feature: SignIn page

  Scenario Outline: Open the SignIn page
    Given 01 Home page is open
    When Open the SignIn page
    And Login page is opened
    When Click on Forgot password?
    And Forgot password page is opened
    Then Sent "<test@test>" e-mail and continue

    Examples:
      | test@test   |
      | test@.com   |
      | test@com    |