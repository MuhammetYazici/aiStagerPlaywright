Feature: AiStager User Registration And Login

  @Regression
  Scenario: The user registers on the AiStager site.
    Given The user clicks the Log in button on the homepage.
    When The user clicks the register button on the login page.
      | kayit ol |
    Then On the registration page,enter a valid email and password.
      | fakerEmail |
      | mamix123?. |
      | mamix123?. |
    And The user checks the terms of acceptance box.
    Then The user clicks the Create an account button.
    And The user must verify the Verify your email text.

  @Regression
  Scenario: The user login on the AiStager webSite.
    Given The user clicks the Log in button on the homepage.
    When On the login page,enter a valid email and password.
      | muhammetyazici611@gmail.com |
      | mamix123?. |
    And The user clicks the button.
      | girisYapButton |