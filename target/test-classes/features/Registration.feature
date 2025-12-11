Feature: Account Registration

  @regression
  Scenario: Successful Account Registration
    Given User navigates to the account registration page
    When User enters the below registration details
      | FirstName       | test       |
      | LastName        | User119    |
      | Telephone       | 1234567890 |
      | Password        | testUser@1 |
      | ConfirmPassword | testUser@1 |
    And User agrees to the Privacy Policy
    And Clicks on Continue button
    Then User should see a confirmation message "Congratulations! Your new account has been successfully created!"