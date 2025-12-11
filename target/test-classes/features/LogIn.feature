Feature: LogIn with valid credentials

  @sanity @regression
  Scenario: Successful login with valid credentials
    Given User navigates to the login page
    When User enters valid username and password as "FirstLastUser1@gmail.com" and "User@1"
    And Clicks on Login button
    Then User should be redirected to the My Account page

  @dataDriven
  Scenario Outline: Successful login with multiple valid credentials
    Given User navigates to the login page
    When User enters valid username and password as "<email>" and "<password>"
    And Clicks on Login button
    Then User should be redirected to the My Account page

    Examples:
      | email                    | password   |
      | testUser119@gmail.com    | testUser@1 |
      | FirstLastUser1@gmail.com | User@1     |
      | firsttester123@gmail.com | test@123   |
