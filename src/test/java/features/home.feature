@Epic_Login_Module
@Feature_Application_Login
Feature: Application Login

  @TC1_Valid_Login @Severity_Critical @Story_User_logs_in_with_valid_credentials
  Scenario: TC1 - Valid login to Swag Labs
    Given User is on the Swag Labs login page
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks the login button
    Then User should see the "Swag Labs" title on the home page

  @TC2_Invalid_Login @Severity_Normal @Story_Invalid_credentials
  Scenario: TC2 - Invalid login to Swag Labs
    Given User is on the Swag Labs login page
    When User enters username "invalid_user" and password "invalid_pass"
    And User clicks the login button
    Then An error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  @TC3_Blank_Login @Severity_Minor @Story_Blank_credentials
  Scenario: TC3 - Blank username and password
    Given User is on the Swag Labs login page
    When User enters username "" and password ""
    And User clicks the login button
    Then An error message "Epic sadface: Username is required" should be displayed

  @TC4_Logout @Severity_Critical @Story_Logout_after_login
  Scenario: TC4 - Successful logout after login
    Given User is on the Swag Labs login page
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks the login button
    And User logs out of the application
    Then User should be redirected to login page with "Swag Labs" title
