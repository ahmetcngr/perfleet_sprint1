Feature: Log out

  @PERF-168
  Scenario:User should able to login
    Given user is on the login page
    When the user enters valid credentials
    Then user should able to log out