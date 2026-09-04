Feature: Forgot Password Test

  @Regression
  Scenario Outline: The user tests the forgot password flow with different email inputs
    Given The user clicks the Log in button on the homepage.
    When The user clicks the forgot password button
    And The user enters "<email>" in the email field
    And The user clicks the send reset email button
    Then The "<expectedMessage>" message should be displayed

    Examples:
      | email                     | expectedMessage          |
      | registered@example.com    | sent                     |
      |                           | enter your email address |
      | invalidformat             | invalid format           |
      | notregistered@example.com | sent                     |

