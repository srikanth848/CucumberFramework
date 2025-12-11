Feature: LogIn Functionality

  @dataDriven
  Scenario Outline: Data driven Login using excel file
    Given User landed on the login page
    When User passes email and password from excel file with row "<row_index>"
    And Clicks on Login
    Then User should navigate to My Account page

    Examples:
      | row_index |
      | 1         |
      | 2         |
      | 3         |
      | 4         |
      | 5         |
