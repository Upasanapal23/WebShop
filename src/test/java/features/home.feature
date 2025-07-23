@Epic_Login_Module
@Feature_Application_Login
@Sanity
Feature: Application Login

  @TC1_Valid_Login @Severity_Critical @Story_User_logs_in_with_valid_credentials
  Scenario: TC1 - Valid login to Swag Labs
    Given User is on the Swag Labs login page
    When User logs in with valid credentials
    Then User should see the expected title on home page

  @TC2_LockedOut_Login @Severity_Normal @Story_Locked_Out_User
  @TC3_Invalid_Login @Severity_Normal @Story_Invalid_User
  @TC4_Blank_Login @Severity_Minor @Story_Blank_Credentials
  Scenario Outline: TC2-TC4 - Login with invalid or blank credentials
    Given User is on the Swag Labs login page
    When User enters username "<username>" and password "<password>"
    Then An error message "<errorMessage>" should be displayed

    Examples:
      | username         | password      | errorMessage                                                            |
      | locked_out_user  | secret_sauce  | Epic sadface: Sorry, this user has been locked out.                    |
      | invalid_user     | wrong_pass    | Epic sadface: Username and password do not match any user in this service |
      |                  |               | Epic sadface: Username is required                                     |
