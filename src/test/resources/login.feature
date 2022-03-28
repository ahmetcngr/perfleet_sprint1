Feature: Login

  @PERF-204
  Scenario: User should able to login
    Given user is on the login page
    When the user enters valid credentials
    Then user should able to login

  @PERF-204
  Scenario: User should NOT able to login with invalid credentials
    Given user is on the login page
    When the user enters invalid credentials
    Then user should able NOT to login

  @PERF-204   @wip
  Scenario: User should see the password in bullet signs by default
    Given user is on the login page
    When the user enters valid credentials
    Then the user should see the password in bullet signs

  @PERF-204
  Scenario: User should able to see and click on "remember me" box
    Given user is on the login page
    When user does not click yet
    Then the user can see and click on remember me box

  @PERF-204
  Scenario: User should see forget password option
    Given user is on the login page
    When user does not click yet
    Then the user can see forget password option