Feature: Forgot Password Test

  @Regression @ForgotPassword
  Scenario Outline: The user tests the forgot password flow with different email inputs
    Given The user clicks the Log in button on the homepage.
    When The user clicks the forgot password button
    And The user enters "<email>" in the email field
    And The user clicks the send reset email button
    Then The "<expectedMessage>" message should be displayed

    Examples:
      | email             | expectedMessage                     |
      | yzcmm61@gmail.com | If an account exists for this email |
      |                   | enter your email address            |
      | invalidformat     | invalid format                      |
      | fakerEmail        | If an account exists for this email |

