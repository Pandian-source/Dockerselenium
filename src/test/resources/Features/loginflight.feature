# Author <angaiyapandiyan@gmail.com>
# Date <13/02/2020>
# Description <Cucumber Test Code>
@SmokeRegression
Feature: Feature to test the login functionality

  @SmokeTest
  Scenario: check login is successful with valid credentials
    Given user open the chrome browser
    Then user is on login page
    When user enters username and password
    And click the login button
    Then user is navigated to the home page
    